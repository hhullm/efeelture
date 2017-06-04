package controller;

public interface MobileApp {

	int register = 1001;                 //注册//
	int login = 1002;                    //登录//
	int updateHeadPic = 1003;            //上传头像//
	int updateAddress = 1004;            //修改地址//
	int eduAuth = 1005;                  //实名认证//
	int modifyUser = 1006;               //修改用户信息//
	int resertPassword = 1007;           //重置密码//
	int findAllLabel = 1008;             //标签库查询//
	int findLabel = 1009;                //个人标签查询//
	int addLabel = 1010;                 //添加标签//
	int deleteLabel = 1011;              //删除标签//
	int findQuestion = 1012;             //查询问题//
	int publishActivity = 1013;          //发布活动//
	int deleteActivity = 1014;           //删除活动//
	int modifyActivity = 1015;           //修改活动信息//
	int findAllActivity = 1016;          //活动概要查询//
	int findActivity = 1017;             //活动详细查询//
	int addFriend = 1018;                //增加好友//
	int deleteFriend = 1019;             //删除好友//
	int modifyFriend = 1020;             //修改好友//
	int findAllFriend = 1021;            //查询好友//
	int addAlbum = 1022;                 //新建相册//
	int deleteAlbum = 1023;              //删除相册//
	int modifyAlbum = 1024;              //修改相册//
	int findAlbum = 1025;                //查询相册//
	int addPhoto = 1026;                 //批量添加照片//
	int deletePhoto = 1027;              //批量删除相片//
	int modifyPhoto = 1028;              //修改相片//
	int findPhoto = 1029;                //查询相片//
	int messageCode = 1030;              //短信验证码

	int modifyPassword = 1031;           //修改密码//
	int addComment = 1032;               //添加一条评论//
	int deleteComment = 1033;            //删除一条评论//
	int addReply = 1034;                 //添加回复//
	int deleteReply = 1035;              //删除回复//

	int queryInfo = 1036;                //根据用户名和用户信息查询用户信息//
	int queryLocation = 1037;            //根据用户地理位置推荐用户//
	int queryPhoto = 1038;               //查询相片详情，包括评论等信息
	int queryFuzzy = 1039;               //模糊查询//待完成
	
	int addphotoComment=1040;            //添加相片评论//
	int deletephotoComment=1041;         //删除相片评论//
	int addphotoReply=1042;              //添加相片评论回复//
	int deletephotoReply=1043;           //删除相片评论回复//
	
	int addCollectionActivity=1044;             //添加一条收藏活动//
	int deleteCollectionActivity=1045;          //取消一条收藏活动//
	int selectCollectionActivity=1046;             //添加一条收藏活动//
	
	int addCollectionPhoto=1047;             //添加一条收藏图片//
	int deleteCollectionPhoto=1048;          //取消一条收藏图片//
	int selectCollectionPhoto=1049;          //取消一条收藏图片//
}
