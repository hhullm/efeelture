package controller;

public interface MobileApp {

	// int forwardCtrl = 1001;// 转发控制
	int saveCtrl = 1002;// 保存控制
	int selectCtrl = 1003;// 选择控制

	int addFriend = 1011;// 添加好友
	// int deleteFriend = 1012;// 删除好友
	//int modifyFriend = 1013;// 修改好友
	int selectFriend = 1014;// 查找好友
	int selectNoFriend = 1015;// 查找非好友
	int modifyFriendStatus = 1016;

	int addHardware = 1021;// 添加硬件
	int deleteHardware = 1022;// 删除硬件
	int selectHardware = 1023;// 查找硬件

	int addJective = 1031;// 添加目标
	int selectJective = 1032;// 查找目标

	int addLike = 1041;// 添加关注
	int deleteLike = 1042;// 取消关注
	int selectLike = 1043;// 查找关注

	int addMessage = 1051;// 添加信息
	//int deleteMessage = 1052;// 删除信息
	int selectFriendMessage = 1053;// 查找好友信息
	int selectMessage = 1054;// 查找信息
	int modifyMessageLikenumber = 1055;// 更新点赞信息
	int modifyMessageStatus = 1056;
	int modifyMessage = 1057;

	int addReply = 1061;// 添加回复
	int deleteReply = 1062;// 删除回复
	int selectReply = 1063;// 查找回复

	int addStatus = 1071;// 添加身份
	int selectStatus = 1072;// 查找身份

	int addTalk = 1081;// 添加聊天
	int deleteTalk = 1082;// 删除聊天
	int selectTalk = 1083;// 查找聊天

	//int bindPhone = 1091;// 关联手机
	//int getCode = 1092;// 获取验证码
	int login = 1093;// 登录
	int modifyPassword = 1094;// 修改密码
	int modifyUser = 1095;// 切换用户
	int register = 1096;// 注册
	int resetPassword = 1097;// 重设密码
	//int uploadPicture = 1098;// 上传图片
	int getUserByType = 1099;// 通过类型找用户

}
