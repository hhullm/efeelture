package controller;

/**
 * @author zhangshu
 * 
 * 与其他接口端通讯
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.User;
import serviceimpl.UserServiceImpl;
import util.MapToEntity;
import util.ResultUtil;

public class MobileAppServlet extends HttpServlet implements MobileApp {

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		request.setCharacterEncoding("UTF-8");
		int tid = Integer.valueOf(request.getParameter("tid"));
		String des = request.getParameter("des");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		Gson gson = new Gson();
		Map<String, Object> map = gson.fromJson(des, new TypeToken<Map<String, Object>>() {
		}.getType());
		switch (tid) {
		case register:
			try {
				if (map.containsKey("custName") && map.containsKey("phoneNumber") && map.containsKey("password")) {
					UserServiceImpl mobile = new UserServiceImpl();
					User user=new User();
					user=MapToEntity.toUser(map);
					String resultCode = mobile.register(user);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case login:
			try {
				if (map.containsKey("custName") && map.containsKey("password")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.login(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case updateHeadPic:
			try {
				if (map.containsKey("custId") && map.containsKey("attaSrc")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.uploadHeadPic(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case updateAddress:
			try {
				if (map.containsKey("custId") && map.containsKey("locationX") && map.containsKey("locationY")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.modifyUser(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case eduAuth:
			try {
				if (map.containsKey("custId") && map.containsKey("name") && map.containsKey("education")
						&& map.containsKey("attaList")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.eduAuth(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case modifyUser:
			try {
				if (map.containsKey("custId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.modifyUser(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case resertPassword:
			try {
				if (map.containsKey("phoneNumber") && map.containsKey("newPassword")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.resertPassword(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case findAllLabel:
			try {
				if (map.size() <= 1) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.findAllLabel(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case findLabel:
			try {
				if (map.containsKey("custId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.findLabel(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case addLabel:
			try {
				if (map.containsKey("custId") && (map.containsKey("label") || map.containsKey("labelSelf"))) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.addLabel(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deleteLabel:
			try {
				if (map.containsKey("custId") && (map.containsKey("label") || map.containsKey("labelSelf"))) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deleteLabel(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case findQuestion:
			try {
				if (map.containsKey("questionType")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.findQuestion(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case publishActivity:
			try {
				if (map.containsKey("custId") && map.containsKey("activityName") && map.containsKey("activityTime")
						&& map.containsKey("activityContent") && map.containsKey("locationX")
						&& map.containsKey("locationY") && map.containsKey("attaList")
						&& (map.containsKey("activityType") || map.containsKey("activityTypeSelf"))) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.publishActivity(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deleteActivity:
			try {
				if (map.containsKey("activityId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deleteActivity(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case modifyActivity:
			try {
				if (map.containsKey("activityId") && map.containsKey("custId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.modifyActivity(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case findAllActivity:
			try {
				if (map.containsKey("pageSize") && map.containsKey("pageNumber")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.findAllActivity(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case findActivity:
			try {
				if (map.containsKey("activityId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.findActivity(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case addFriend:
			try {
				if (map.containsKey("custId") && map.containsKey("friendName") && map.containsKey("friendCustId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.addFriend(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deleteFriend:
			try {
				if (map.containsKey("custId") && map.containsKey("friendCustId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deleteFriend(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case modifyFriend:
			try {
				if (map.containsKey("custId") && map.containsKey("friendCustId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.modifyFriend(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case findAllFriend:
			try {
				if (map.containsKey("custId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.findAllFriend(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case addAlbum:
			try {
				if (map.containsKey("custId") && map.containsKey("albumName")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.addAlbum(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deleteAlbum:
			try {
				if (map.containsKey("albumId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deleteAlbum(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case modifyAlbum:
			try {
				if (map.containsKey("albumId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.modifyAlbum(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case findAlbum:
			try {
				if (map.containsKey("custId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.findAlbum(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case addPhoto:
			try {
				if (map.containsKey("albumId") && map.containsKey("photoList")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.addPhoto(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deletePhoto:
			try {
				if (map.containsKey("photoList")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deletePhoto(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case modifyPhoto:
			try {
				if (map.containsKey("photoId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.modifyPhoto(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case findPhoto:
			try {
				if (map.containsKey("albumId") || map.containsKey("photoId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.findPhoto(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case messageCode:
			try {
				if (true) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.messageCode(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case modifyPassword:
			try {
				if (map.containsKey("custId") && map.containsKey("oldPassword") && map.containsKey("newPassword")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.modifyPassword(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case addComment:
			try {
				if (map.containsKey("custId") && map.containsKey("activityId") && map.containsKey("commentType")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.addComment(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deleteComment:
			try {
				if (map.containsKey("commentId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deleteComment(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case addReply:
			try {
				if (map.containsKey("commentId") && map.containsKey("custId") && map.containsKey("replyContent")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.addReply(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deleteReply:
			try {
				if (map.containsKey("replyId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deleteReply(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case queryInfo:
			try {
				if (map.containsKey("custName")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.queryInfo(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case queryLocation:
			try {
				if (map.containsKey("locationX") && map.containsKey("locationY")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.queryLocation(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case queryPhoto:
			try {
				if (map.containsKey("photoId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.queryPhotoInfo(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case queryFuzzy:
			try {
				if (map.containsKey("queryContent")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.queryFuzzy(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case addphotoComment:
			try {
				if (map.containsKey("custId") && map.containsKey("photoId") && map.containsKey("photoCommentType")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.addPhotoComment(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deletephotoComment:
			try {
				if (map.containsKey("custId") && map.containsKey("photoCommentId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deletePhotoComment(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case addphotoReply:
			try {
				if (map.containsKey("custId") && map.containsKey("photoCommentId")
						&& map.containsKey("photoReplyCustId") && map.containsKey("photoReplyType")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.addPhotoReply(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deletephotoReply:
			try {
				if (map.containsKey("custId") && map.containsKey("photoReplyId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deletePhotoReply(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case addCollectionActivity:
			try {
				if (map.containsKey("custId") && map.containsKey("activityId") && map.containsKey("commentType")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.addCollectionActivity(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deleteCollectionActivity:
			try {
				if (map.containsKey("custId") && map.containsKey("activityId") && map.containsKey("commentType")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deleteCollectionActivity(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectCollectionActivity:
			try {
				if (map.containsKey("custId") && map.containsKey("activityId") && map.containsKey("commentType")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deleteCollectionActivity(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case addCollectionPhoto:
			try {
				if (map.containsKey("custId") && map.containsKey("activityId") && map.containsKey("photoId")
						&& map.containsKey("attaList")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.addCollectionPhoto(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case deleteCollectionPhoto:
			try {
				if (map.containsKey("custId") && map.containsKey("activityId") && map.containsKey("photoId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deleteCollectionPhoto(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		case selectCollectionPhoto:
			try {
				if (map.containsKey("custId") && map.containsKey("activityId") && map.containsKey("photoId")) {
					MobileAppServiceImpl mobile = new MobileAppServiceImpl();
					String resultCode = mobile.deleteCollectionPhoto(map);
					out.write(resultCode);
				} else
					out.write(ResultUtil.getResultCode());
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		default:
			try {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("resultCode", "0000");
				String resultCode = gson.toJson(m);
				out.write(resultCode);
			} catch (Exception e) {
				e.printStackTrace();
				out.write(ResultUtil.getErrorResultCode());
			}
			break;
		}
		out.close();
	}

}
