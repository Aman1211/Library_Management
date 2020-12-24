package library.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import library.dao.Requestdao;
import library.dao.Reservedao;
import library.dao.Userdao;
import library.dao.Bookdao;

public class ReserveServiceImpl extends ReserveService {

	public int addReserve(ReserveTO rt, HttpServletResponse res, HttpServletRequest req) {

		int i = rdao.checkReservation(rt);
		/*
		 * if(i==0) { return 0; } else if(i==-1) { return -1; } else if(i==1) {
		 * 
		 * rdao.addReserve(rt); return 1;
		 * 
		 * } return 2;
		 */
		if (i == -1) {
			return -1;
		} else {
			int i2 = rdao.checkTransaction(rt);
			if (i2 == 0) {
				return 0;
			} else {
				rdao.addReserve(rt);
				return 1;
			}
		}
	}

	public void cancelReserve(String isbn, String username) {

		rdao.cancelReserve(isbn, username);
	}

	public ArrayList<ReserveTO> getReservations(String username) {
		return rdao.fetchReservations(username);
	}

	public boolean getReservation(String isbn) {
		ArrayList<ReserveTO> rt = new ArrayList<>();
		rt = rdao.verifyReservation(isbn);
		if (rt.isEmpty()) {
			return true;
		} else
			return false;
	}

	public void notify(String isbn) {
		ReserveTO rt = new ReserveTO();
		rt = rdao.fetchnonnotify(isbn);

		UserTO ut = udao.Exists(rt.getUsername());
		if (ut.getUsername() == null)
			return;
		BookTO bt = bdao.Exists(isbn);
		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("lmsecdss@gmail.com", "lms$1234");
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("lmsecdss@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(ut.getUsername()));
			message.setSubject("Reserved Book Available");

			message.setContent("<b> Hello " + ut.getName()
					+ ",</b><br><h3>The following book reserved by you is now available in catalogue</h3><br>"
					+ bt.getISBN() + "," + bt.getTitle() + "," + bt.getAuthor() + "<br><br> Regards,<br>Library Admin.",
					"text/html");

			Transport.send(message);
			rdao.marknotify(rt.getId());
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}

	private Reservedao rdao = new Reservedao();
	private Userdao udao = new Userdao();
	private Bookdao bdao = new Bookdao();
}
