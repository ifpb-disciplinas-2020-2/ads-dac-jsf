package br.edu.ifpb.web.jsp;

import br.edu.ifpb.domain.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// MCV - HTML (View) -> Servlet (Controller) -> Pessoa (Model)
@WebServlet(name = "ControladorDePessoa",urlPatterns = {"/controladorDePessoa"})
public class ControladorDePessoa extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        //processar a requisição
        String nome = request.getParameter("nome");
        Pessoa pessoa = new Pessoa(nome);
        // executar a lógica de negócio
        pessoa.alterarNome();
        // redirecionar ou encaminhar uma resposta ao usuário
        encaminharResposta(request,response,pessoa);
        

    } 

    private void encaminharResposta(HttpServletRequest request, HttpServletResponse response,Pessoa pessoa) throws IOException {
        //        request.getSession().setAttribute("nome",nome);
        // encaminhar ao usuário -> nova requisição
//        response.sendRedirect("home.xhtml");
        // encaminhar a requisição
//        request.getRequestDispatcher("home.xhtml").forward(request,response);
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDePessoa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Nome: " + pessoa.getNome() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

}
