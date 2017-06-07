package controller;

public interface MobileApp {

	int forwardCtrl = 1001;
	int saveCtrl = 1002;
	int selectCtrl = 1003;
	
	int addFriend = 1011;
	int deleteFriend = 1012;
	int modifyFriend = 1013;
	int selectFriend = 1014;
	int selectNoFriend = 1015;
	
	int addHardware = 1021;
	int deleteHardware = 1022;
	int selectHardware = 1023;
	
	int addJective = 1031;
	int selectJective = 1032;
	
	int addLike = 1041;
	int deleteLike = 1042;
	int selectLike = 1043;
	
	int addMessage = 1051;
	int deleteMessage = 1052;
	int selectFriendMessage = 1053;
	int selectMessage = 1054;
	
	int addReply = 1061;
	int deleteReply = 1062;
	int selectReply = 1063;
	
	int addStatus = 1071;
	int selectStatus = 1072;
	
	int addTalk = 1081;
	int deleteTalk = 1082;
	int selectTalk = 1083;
	
	int bindPhone = 1091;
	int getCode = 1092;
	int login = 1093;
	int modifyPassword = 1094;
	int modifyUser = 1095;
	int register = 1096;
	int resetPassword = 1097;
	int uploadPicture = 1098;

}
