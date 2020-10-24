package library.filters;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import java.io.IOException;
import javax.servlet.ServletException;
public interface Filter {
public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws IOException,ServletException;
}
