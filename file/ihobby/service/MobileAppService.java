package service;

import java.util.Map;

/**
 * 
 * @author 994072500
 *
 * @deprecated 手机端接口服务层
 */
public interface MobileAppService {

	/*
	 * 注册
	 */
	String register(Map<String, Object> map);

	/*
	 * 登录
	 */
	String login(Map<String, Object> map);

	/*
	 * 头像上传
	 */
	String uploadHeadPic(Map<String, Object> map);

	/*
	 * 实名认证
	 */
	String eduAuth(Map<String, Object> map);

	/*
	 * 用户信息修改
	 */
	String modifyUser(Map<String, Object> map);

	/*
	 * 重置密码
	 */
	String resertPassword(Map<String, Object> map);

	/*
	 * 查找标签库
	 */
	String findAllLabel(Map<String, Object> map);

	/*
	 * 查找用户的标签
	 */
	String findLabel(Map<String, Object> map);

	/*
	 * 用户增加标签
	 */
	String addLabel(Map<String, Object> map);

	/*
	 * 删除标签
	 */
	String deleteLabel(Map<String, Object> map);

	/*
	 * 查找问题
	 */
	String findQuestion(Map<String, Object> map);

	/*
	 * 发布活动
	 */
	String publishActivity(Map<String, Object> map);

	/*
	 * 删除活动
	 */
	String deleteActivity(Map<String, Object> map);

	/*
	 * 修改活动信息
	 */
	String modifyActivity(Map<String, Object> map);

	/*
	 * 根据条件查找活动
	 */
	String findAllActivity(Map<String, Object> map);

	/*
	 * 查找活动详情
	 */
	String findActivity(Map<String, Object> map);

	/*
	 * 添加好友
	 */
	String addFriend(Map<String, Object> map);

	/*
	 * 删除一个好友
	 */
	String deleteFriend(Map<String, Object> map);

	/*
	 * 修改好友信息
	 */
	String modifyFriend(Map<String, Object> map);

	/*
	 * 查询好友列表
	 */
	String findAllFriend(Map<String, Object> map);

	/*
	 * 新建一个相册
	 */
	String addAlbum(Map<String, Object> map);

	/*
	 * 删除一个相册
	 */
	String deleteAlbum(Map<String, Object> map);

	/*
	 * 修改相册信息
	 */
	String modifyAlbum(Map<String, Object> map);

	/*
	 * 查询相册列表
	 */
	String findAlbum(Map<String, Object> map);

	/*
	 * 新增一张照片
	 */
	String addPhoto(Map<String, Object> map);

	/*
	 * 删除一张照片
	 */
	String deletePhoto(Map<String, Object> map);

	/*
	 * 修改相片信息（移动相片位置）
	 */
	String modifyPhoto(Map<String, Object> map);

	/*
	 * 查询一个相册中的相片
	 */
	String findPhoto(Map<String, Object> map);

	/*
	 * 短信验证码（待完成）
	 */
	String messageCode(Map<String, Object> map);

	/*
	 * 修改密码
	 */
	String modifyPassword(Map<String, Object> map);

	/*
	 * 增加评论，点赞或者参与活动
	 */
	String addComment(Map<String, Object> map);

	/*
	 * 删除评论或者取消点赞
	 */
	String deleteComment(Map<String, Object> map);

	/*
	 * 增加一个回复
	 */
	String addReply(Map<String, Object> map);

	/*
	 * 删除一个回复
	 */
	String deleteReply(Map<String, Object> map);

	/*
	 * 根据用户的姓名手机号码查询
	 */
	String queryInfo(Map<String, Object> map);

	/*
	 * 根据用户的地理位置查询
	 */
	String queryLocation(Map<String, Object> map);

	/*
	 * 模糊查询（待完成）
	 */
	String queryFuzzy(Map<String, Object> map);

	/*
	 * 添加相片评论
	 */
	String addPhotoComment(Map<String, Object> map);

	/*
	 * 删除相片评论
	 */
	String deletePhotoComment(Map<String, Object> map);

	/*
	 * 添加相片评论的回复
	 */
	String addPhotoReply(Map<String, Object> map);

	/*
	 * 删除相片评论的回复
	 */
	String deletePhotoReply(Map<String, Object> map);

	/*
	 * 查询相片及其相关评论点赞信息
	 */
	String queryPhotoInfo(Map<String, Object> map);
	/*
	 * 
	 */
	String addCollectionActivity(Map<String, Object> map);
	/*
	 * 
	 */
	String deleteCollectionActivity(Map<String, Object> map);
	/*
	 * 
	 */
	String selectCollectionActivity(Map<String, Object> map);
}
