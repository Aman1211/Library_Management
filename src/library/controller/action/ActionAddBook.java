package library.controller.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.controller.Action;

public class ActionAddBook  implements Action {

    @Override
    public String perform(HttpServletRequest request,
            HttpServletResponse response) {
            request.setAttribute("book", null);
            return "add_book.jsp";
    }
}
