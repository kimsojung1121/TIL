package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//�Է����������� ���޵� ��Ƽ��Ʈ ������Ÿ�� ó���ϱ� ���� Ŭ���� �ʿ�
// => Apache �׷쿡�� ������ commons-fileupload ���̺귯���� Ŭ���� ��� - ������ ���� ���ε�
// => Oreilly �׷쿡�� ������ cos ���̺귯���� Ŭ���� ��� - ������ ���� ���ε�

//Oreilly �׷쿡�� ������ cos ���̺귯�� ������ �ٿ�ε� �޾� ������Ʈ�� ����(Build) ó���ϴ� ���
//1.http://www.servlets.com >> COS File Upload Library �޴� Ŭ�� >> cos-20.08.zip �ٿ�ε�
//2.cos-20.08.zip ���� ���� Ǯ�� >> ���� ���� >> lib >> cos.jar ����
//3.������Ʈ >> src/main/wabapp >> WEB-INF >> lib ������ cos.jar ���� �ٿ��ֱ�
// => ���̺귯���� �ڵ����� ������Ʈ�� ���� ó�� - Web App Libraries Ȯ��

//�Է�������(file_upload.html)���� ���޵� �Է°��� �Է� ���ϸ��� ��ȯ�޾� Ŭ���̾�Ʈ���� �����ϴ� ����
// => �Է� ������ ���޹޾� ���� ���丮�� ����ǵ��� ó�� - ���ε�(Upload)
@WebServlet("/upload.itwill")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//���������� ��û�� ���� ó��
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("file_upload.html");//�Է��������� �̵� ó��
			return;
		}
		
		//���޵� ������ �����ϱ� ���� ���� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		// => �۾� ���丮(WorkSpace)�� �ƴ� �� ���丮(WebApps)�� �ý��� ��� ��ȯ
		//����)WAS ����� �۾� ���丮�� ������Ʈ�� �� ���丮�� ���ؽ�Ʈ�� ����ȭ ó��
		//�Ǹ鼭 ���ؽ�Ʈ�� �����ϴ� ���� ���ε� ������ �������� ���� �߻�
		String saveDirectory=request.getServletContext().getRealPath("/upload");
		//System.out.println("saveDirectory = "+saveDirectory);
		
		//MultipartRequest Ŭ������ �ν��Ͻ� ����
		// => MultipartRequest : ��Ƽ��Ʈ ������Ÿ�� ó���ϱ� ���� ����� �����ϴ� �ν��Ͻ�
		// => MultipartRequest �ν��Ͻ��� �����ϸ� ��� �Է������� ���޹޾� ���� ���丮�� �ڵ� ����
		//MultipartRequest(HttpServletRequest request, String saveDirectory[, int maxPostSize]
		//[, String encoding][, FileRenamePolicy policy]) �����ڸ� ����Ͽ� �ν��Ͻ� ����
		// => request : ��û������ ������ HttpServletRequest �ν��Ͻ� ����
		// => saveDirectory : ���� ������ �����ϱ� ���� ���� ���丮�� �ý��� ��� ����
		// => maxPostSize : ó�� ������ ��Ƽ��Ʈ ������Ÿ�� �ִ� ũ�� ���� - ���� : Byte
		// => encoding : ��Ƽ��Ʈ ������Ÿ�� ���޵� �Է°��� ĳ���ͼ� ����
		// => policy : FileRenamePolicy �ν��Ͻ� ����
		//FileRenamePolicy : ���� ���ε� ó���� �Է����ϰ� ���� �̸��� ������ ���ε� �Ǵ� 
		//���� ���丮�� �̹� ������ ��� �Է������� �̸��� �ڵ� �����ϴ� �ν��Ͻ�
		// => FileRenamePolicy �ν��Ͻ��� �������� ������ ���� ������ �Է����Ϸ� ������(OverWrite)
		//MultipartRequest mr=new MultipartRequest(request, saveDirectory, 30*1024*1024, "utf-8");
		
		//FileRenamePolicy �������̽��� ��ӹ��� �ڽ�Ŭ������ FileRenamePolicy �ν��Ͻ� ����
		//DefaultFileRenamePolicy : FileRenamePolicy �������̽��� ��ӹ��� �ڽ�Ŭ����
		// => �Է����ϸ� �ڿ� ���ڸ� �ٿ� �ڵ����� �����ϴ� ����� ���� 
		MultipartRequest mr=new MultipartRequest(request, saveDirectory, 30*1024*1024
				, "utf-8", new DefaultFileRenamePolicy());
		
		//�Է°��� ��ȯ�޾� ����
		//MultipartRequest.getParameter(String name) : ��Ƽ��Ʈ ������Ÿ�� �Է°��� ��ȯ�ϴ� �޼ҵ�
		String name=mr.getParameter("name");
		
		//�Է� ���ϸ��� ��ȯ�޾� ����
		//MultipartRequest.getOriginalFileName(String name) : ��Ƽ��Ʈ ������Ÿ�� �Է� ���ϸ��� ��ȯ�ϴ� �޼ҵ�
		//String fileone=mr.getOriginalFileName("fileone");
		//String filetwo=mr.getOriginalFileName("filetwo");
		
		//���� ���丮 ����� ���ε� ���ϸ��� ��ȯ�޾� ����
		//MultipartRequest.getFilesystemName(String name) : ���� ���丮�� ���� ����� ���ϸ��� ��ȯ�ϴ� �޼ҵ�
		String fileone=mr.getFilesystemName("fileone");
		String filetwo=mr.getFilesystemName("filetwo");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>���� ���ε�</h1>");
		out.println("<hr>");
		out.println("<p>�ø��� = "+name+"</p>");
		out.println("<p>����-1 = "+fileone+"</p>");
		out.println("<p>����-2 = "+filetwo+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
}

