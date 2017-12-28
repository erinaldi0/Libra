package it.unisa.libra.filter;

import com.mysql.jdbc.StringUtils;
import it.unisa.libra.util.JspPagesIndex;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class NegaStudente. Nega l'accesso alla risorsa richiesta dallo
 * studente.
 * 
 * @see javax.servlet.Filter
 */
public class NegaStudente implements Filter {

  /** Default constructor. */
  public NegaStudente() {}

  /**
   * Override.
   * 
   * @see Filter#destroy()
   */
  public void destroy() {}

  /**
   * Override. Se l'utente loggato è uno studente, reindirizza ad una pagina di errore.
   * 
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    String utenteRuolo =
        (String) ((HttpServletRequest) request).getSession().getAttribute("utenteRuolo");

    // se l'utente non è loggato, si è verificato un errore nella catena di filtri
    // se l'utente è uno studente l'accesso è negato
    if ((StringUtils.isNullOrEmpty(utenteRuolo)) || "Studente".equals(utenteRuolo)) {
      ((HttpServletResponse) response).sendRedirect(
          ((HttpServletRequest) request).getContextPath() + JspPagesIndex.ACCESSO_NEGATO);
      return;

    }
    
    chain.doFilter(request, response);
    
  }

  /**
   * Override.
   * 
   * @see Filter#init(FilterConfig)
   */
  public void init(FilterConfig fConfig) throws ServletException {}
}
