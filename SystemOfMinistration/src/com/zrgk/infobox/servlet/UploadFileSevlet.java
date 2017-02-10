package com.zrgk.infobox.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zrgk.infobox.model.MailBox;
import com.zrgk.infobox.service.MailBoxServiceInter;
import com.zrgk.infobox.service.impl.MailBoxServiceImpl;

/**
 * �����ļ��ϴ���д��Ϣ��servlet
 */

public class UploadFileSevlet extends HttpServlet {
	
	MailBoxServiceInter  mailBoxService=new MailBoxServiceImpl();//ʵ����
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		String path = request.getRealPath("/upload");//�ļ������WebRoot�µ�upload�ļ�����
		DiskFileItemFactory fileFactory = new DiskFileItemFactory(1024 * 1024,new File(path));//�ϴ��ļ�Ҫ�õ���file������
		
		ServletFileUpload upload = new ServletFileUpload(fileFactory);
		 MailBox  mailBox=new MailBox();//��ʼ��
		// mailBox.setTime("time");
		 
//		 HttpSession session=request.getSession();//ͨ��session��ȡ�����˵�����
//			String user=(String) session.getAttribute("emplInfo"��empl);
		 
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//��õ�ǰ��ʱ��
			String ime=sdf.format(new Date());
		try {
			List<FileItem> list = upload.parseRequest(request);//list���Ǵ���ҳ�����еĹ����ı����ѡ���֮���Ԫ�ر�ǩ
			
			for (FileItem item : list) {
				//(item.isFormField()���ж��Ƿ���ҳ���������ı���Ԫ��
				
				if (item.isFormField()) {
					String fieldName = item.getFieldName();
					String fieldValue = item.getString("utf-8");
					System.out.println(fieldName+":"+fieldValue);
					
					if(fieldName.equals("title")){
						mailBox.setTitle(fieldValue);
					}
					else if(fieldName.equals("content")){
						mailBox.setContent(fieldValue);
					}
					else if(fieldName.equals("adressee")){
						mailBox.setAdressee(Integer.parseInt(fieldValue));
						
						
					}
//					else if(fieldName.equals("adresser")){
//						mailBox.setAdresser(Integer.parseInt(fieldValue));	
//						
//					}

					}else {
					//ҳ���Ӧ��<input type="file" �ϴ��ļ� �Ĵ���
					String fieldName = item.getFieldName();
					String oldFileName = item.getName();
					
					if(oldFileName!=null&&!"".equals(oldFileName.trim())){
						//ȡԭʼ�ļ����ĺ�׺
						String last=oldFileName.substring(oldFileName.lastIndexOf("."),oldFileName.length());
						System.out.println("last="+last);
						String fileName =String.valueOf(System.currentTimeMillis())+last;
						request.setAttribute("fileName", fileName);
						mailBox.setSlave(fileName);
						//���ļ���������ʽд��Ӳ����ȥ
						InputStream inputStream = item.getInputStream();
						OutputStream outputStream = new FileOutputStream(new File(
								path, fileName));
						int lenght = 0;
						byte[] b = new byte[500];
						while ((lenght = inputStream.read(b)) > 0) {
							outputStream.write(b, 0, lenght);
						}
						outputStream.close();
						inputStream.close();
					}	
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			mailBox.setTime(ime);//ʱ�丳ֵ
				//System.out.println(ime);
			
		//mailBox.setAdresser(Integer.parseInt("user"));//��ֵ�����˵������ݿ�
			mailBox.setAdresser(67);
			
			mailBoxService.insertMailBox(mailBox);
			
		request.getRequestDispatcher("seekMailServlet.action").forward(request, response);
		
	}
}