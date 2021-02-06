/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 833989
 */
public class NoteServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        String title =br.readLine();
        String content =br.readLine();
        br.close();
        String edit = request.getParameter("edit");
        
        if(edit != null) {
            request.setAttribute("editTitle", title);
            request.setAttribute("editContents", content);
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        else{
            request.setAttribute("title", title);
            request.setAttribute("content", content);
            
            Note note = new Note (title, content);
            request.setAttribute("note", note);
            
            getServeletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
            

      }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        String editTitle = request.getParameter("editTitle");
        String editContent = request.getParameter("editContent");
        
        Note note = new Note (editTitle, editContent);
        request.setAttribute("note", note);
        
        pw.println(note.getTitle());
        pw.println(note.getContent());
        pw.close();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();          
        String content = br.readLine();
        
        request.setAttribute("title", title);
        request.setAttribute("content", content);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        br.close();
    }

}