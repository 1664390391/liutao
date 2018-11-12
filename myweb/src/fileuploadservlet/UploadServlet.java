package fileuploadservlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload/uploadServlet")
public class UploadServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//执行上传文件的操作
	//	request.setCharacterEncoding("utf-8");
		//第一步，判断表单是否支持文件上传：检验表单的支持类型
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart){
			System.out.println("���Ͳ�֧��");
			throw new RuntimeException();
		}
		//第二部：创建一个DiskFileItemfactory工厂类，得到工厂对象，和磁盘打交道
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//第三部：创建一个servletFileUpload核心对象处理上传数据
		ServletFileUpload sfu = new ServletFileUpload(factory);	
		sfu.setHeaderEncoding("utf-8");
		//限制文件上传的大小
		sfu.setFileSizeMax(1024*1024*5);
//		第四部：解析request，获得表单项集合，并处理
		try {
			//解析request ，获得fileitems
			List<FileItem> fileitems = sfu.parseRequest(request);

			//遍历表单数据
			for (FileItem fileItem : fileitems) {
				if(fileItem.isFormField()) {
					//普通表单相
					processFormFiled(fileItem);
				}else{
					//文件表单相
					processUploadField(fileItem);
				}
			}	
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private void processUploadField(FileItem fileItem) {
		//第一步：得到上传文件的名字
		String filename = fileItem.getName();
		System.out.println("filename=" + filename);
		//File.separator  在windows和linux等环境下能自动识别分隔符；
//		filename = filename.substring(filename.lastIndexOf(File.separator));
		if (filename != null) {
			filename = FilenameUtils.getName(filename);
		}
		//得到文件输入流
		try {
			InputStream is = fileItem.getInputStream();
			//创建存盘的目录
			SimpleDateFormat bartDateFormat = new SimpleDateFormat
					("yyyy-MM-dd");
			Date date = new Date();
			System.out.println(bartDateFormat.format(date));
			//设置需要保存的路径,为了安全性，放置在WEB中
			String directroyRealPath = this.getServletContext().getRealPath("WEB-INF" + File.separator + "upload" + File.separator + bartDateFormat.format(date));
			//创建目录
			File storeDirectroy = new File(directroyRealPath);
			//判断目录是否存在
			if (!storeDirectroy.exists()) {
				System.out.println("storeDirectroy=" + storeDirectroy);
				storeDirectroy.mkdirs();
			}
			//传入文件目录和文件名
			File file = new File(storeDirectroy, filename);
			//使用问价输出流将文件上传至磁盘
			FileOutputStream fos = new FileOutputStream(file);

			int len = 0;
			byte[] b = new byte[1024];
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			fos.close();
			is.close();
			//结束之后删除临时文件，原理 未完全理解，
			fileItem.delete();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void processUploadField2(@RequestParam(value = "file", required = false) MultipartFile[] files) {
		//第一步：得到上传文件的名字
		String filename = files[0].getOriginalFilename();
		//File.separator  在windows和linux等环境下能自动识别分隔符；
//			filename = filename.substring(filename.lastIndexOf(File.separator));
		if(filename != null) {
			filename = FilenameUtils.getName(filename);
		}
		//得到文件输入流
		try {
			InputStream is = files[0].getInputStream();

			//设置需要保存的路径,为了安全性，放置在WEB中
//	            String directroyRealPath = this.getRequest().getContextPath()+ File.separator+"pic_file";
			String directroyRealPath = "C:\\gzdemopic";
			//创建目录
			File storeDirectroy = new File(directroyRealPath);
			//判断目录是否存在
			if(!storeDirectroy.exists()) {
				System.out.println("storeDirectroy="+storeDirectroy);
				storeDirectroy.mkdirs();
			}
			//传入文件目录和文件名
			File file = new File(storeDirectroy,filename);
			//使用问价输出流将文件上传至磁盘
			FileOutputStream fos = new FileOutputStream(file);

			int len = 0;
			byte[] b = new byte[1024];
			while((len = is.read(b))!= -1) {
				fos.write(b, 0, len);
			}
			fos.close();
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	private void processFormFiled(FileItem fileItem) throws UnsupportedEncodingException {
		String fieldname = fileItem.getFieldName();//普通表单字段名
		String fieldvalue = fileItem.getString("UTF-8");//普通表单字段值
		
			//fieldvalue = new String(fieldvalue.getBytes("iso-8859-1"),"utf-8");
	
		System.out.println("表单数据："+fieldname+"="+fieldvalue);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
