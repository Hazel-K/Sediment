package blog.hyojin4588.pjt;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.hyojin4588.pjt.vo.UserVO;

public class Utils {
	
	public static String encryptString(String str) {
		String sha = "";

	       try{
	          MessageDigest sh = MessageDigest.getInstance("SHA-256");
	          sh.update(str.getBytes());
	          byte byteData[] = sh.digest();
	          StringBuffer sb = new StringBuffer();
	          for(int i = 0 ; i < byteData.length ; i++){
	              sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
	          }

	          sha = sb.toString();

	      }catch(NoSuchAlgorithmException e){
	          //e.printStackTrace();
	          System.out.println("Encrypt Error - NoSuchAlgorithmException");
	          sha = null;
	      }

	      return sha;
	}
	
	public static boolean isLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// true면 로그인 안됨, false면 로그인 된 상태
		boolean result = false;
		HttpSession hs = request.getSession();
		if(null == hs.getAttribute(Const.LOGIN_USER)) {
			result = !result;
			response.sendRedirect("login");
			return result;
		}
		return result;
	}
	
	public static int parseStringToInt(String arg0) {
		return parseStringToInt(arg0, 0);
	}
	
	public static int parseStringToInt(String arg0, int arg1) {
		try {
			return Integer.parseInt(arg0);
		} catch (Exception e) {
			return arg1;
		}
	}
	
	public static UserVO userInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession hs = request.getSession();
		UserVO vo = (UserVO)hs.getAttribute(Const.LOGIN_USER);
		if(null != vo) {
			return vo;			
		}
		response.sendRedirect("login");
		return vo;
	}

}
