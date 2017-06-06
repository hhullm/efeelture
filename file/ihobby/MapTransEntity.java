package utils;

import java.util.Map;

import entity.Activity;
import entity.Album;
import entity.Attachment;
import entity.Comment;
import entity.Friend;
import entity.Game;
import entity.Interest;
import entity.Label;
import entity.Menu;
import entity.Photo;
import entity.PhotoComment;
import entity.PhotoReply;
import entity.Question;
import entity.Reply;
import entity.User;

public class MapTransEntity {
	public static User transUser(Map<String, Object> map) {
		User user = new User();
		if (map.containsKey("custId"))
			user.setCustId((String) map.get("custId"));
		if (map.containsKey("email"))
			user.setEmail((String) map.get("email"));
		if (map.containsKey("custName"))
			user.setCustName((String) map.get("custName"));
		if (map.containsKey("phoneNumber"))
			user.setPhoneNumber((String) map.get("phoneNumber"));
		if (map.containsKey("password"))
			user.setPassword((String) map.get("password"));
		if (map.containsKey("gender"))
			user.setGender((String) map.get("gender"));
		if (map.containsKey("lastLoginTime"))
			user.setLastLoginTime((String) map.get("lastLoginTime"));
		if (map.containsKey("questionId"))
			user.setQuestionId((String) map.get("questionId"));
		if (map.containsKey("answer"))
			user.setAnswer((String) map.get("answer"));
		if (map.containsKey("custStatus"))
			user.setCustStatus((String) map.get("custStatus"));
		if (map.containsKey("custVip"))
			user.setCustVip((String) map.get("custVip"));
		if (map.containsKey("custQq"))
			user.setCustQq((String) map.get("custQq"));
		if (map.containsKey("name"))
			user.setName((String) map.get("name"));
		if (map.containsKey("locationX"))
			user.setLocationX((String) map.get("locationX"));
		if (map.containsKey("locationY"))
			user.setLocationY((String) map.get("locationY"));
		if (map.containsKey("birthday"))
			user.setBirthday((String) map.get("birthday"));
		if (map.containsKey("education"))
			user.setEducation((String) map.get("education"));
		if (map.containsKey("address"))
			user.setAddress((String) map.get("address"));
		if (map.containsKey("signature"))
			user.setSignature((String) map.get("signature"));
		return user;
	}

	public static Activity transActivity(Map<String, Object> map) {
		Activity activity = new Activity();
		if (map.containsKey("custId"))
			activity.setCustId((String) map.get("custId"));
		if (map.containsKey("activityId"))
			activity.setActivityId((String) map.get("activityId"));
		if (map.containsKey("attaId"))
			activity.setAttaId((String) map.get("attaId"));
		if (map.containsKey("activityName"))
			activity.setActivityName((String) map.get("activityName"));
		if (map.containsKey("activityType"))
			activity.setActivityType((String) map.get("activityType"));
		if (map.containsKey("activityContent"))
			activity.setActivityContent((String) map.get("activityContent"));
		if (map.containsKey("publishTime"))
			activity.setPublishTime((String) map.get("publishTime"));
		if (map.containsKey("activityTime"))
			activity.setActivityTime((String) map.get("activityTime"));
		if (map.containsKey("activityFinishTime"))
			activity.setActivityFinishTime((String) map.get("activityFinishTime"));
		if (map.containsKey("isEf"))
			activity.setIsEf((String) map.get("isEf"));
		if (map.containsKey("activityClass"))
			activity.setActivityClass((String) map.get("activityClass"));
		if (map.containsKey("activityTypeSelf"))
			activity.setActivityTypeSelf((String) map.get("activityTypeSelf"));
		if (map.containsKey("locationX"))
			activity.setLocationX((String) map.get("locationX"));
		if (map.containsKey("locationY"))
			activity.setLocationY((String) map.get("locationY"));
		if (map.containsKey("address"))
			activity.setAddress((String) map.get("address"));
		return activity;
	}

	public static Album transAlbum(Map<String, Object> map) {
		Album album = new Album();
		if (map.containsKey("custId"))
			album.setCustId((String) map.get("custId"));
		if (map.containsKey("albumId"))
			album.setAlbumId((String) map.get("albumId"));
		if (map.containsKey("albumName"))
			album.setAlbumName((String) map.get("albumName"));
		if (map.containsKey("albumDesc"))
			album.setAlbumDesc((String) map.get("albumDesc"));
		if (map.containsKey("createAlbumTime"))
			album.setCreateAlbumTime((String) map.get("createAlbumTime"));
		if (map.containsKey("albumType"))
			album.setAlbumType((String) map.get("albumType"));
		return album;
	}

	public static Attachment transAttachment(Map<String, Object> map) {
		Attachment atta = new Attachment();
		if (map.containsKey("custId"))
			atta.setCustId((String) map.get("custId"));
		if (map.containsKey("attaId"))
			atta.setAttaId((String) map.get("attaId"));
		if (map.containsKey("attaName"))
			atta.setAttaName((String) map.get("attaName"));
		if (map.containsKey("attaSrc"))
			atta.setAttaSrc((String) map.get("attaSrc"));
		if (map.containsKey("attaType"))
			atta.setAttaType((String) map.get("attaType"));
		if (map.containsKey("attaTime"))
			atta.setAttaTime((String) map.get("attaTime"));
		return atta;
	}

	public static Comment transComment(Map<String, Object> map) {
		Comment comment = new Comment();
		if (map.containsKey("custId"))
			comment.setCustId((String) map.get("custId"));
		if (map.containsKey("activityId"))
			comment.setActivityId((String) map.get("activityId"));
		if (map.containsKey("commentId"))
			comment.setCommentId((String) map.get("commentId"));
		if (map.containsKey("commentContent"))
			comment.setCommentContent((String) map.get("commentContent"));
		if (map.containsKey("commentTime"))
			comment.setCommentTime((String) map.get("commentTime"));
		if (map.containsKey("commentType"))
			comment.setCommentType((String) map.get("commentType"));
		return comment;
	}

	public static Friend transFriend(Map<String, Object> map) {
		Friend friend = new Friend();
		if (map.containsKey("custId"))
			friend.setCustId((String) map.get("custId"));
		if (map.containsKey("friendName"))
			friend.setFriendName((String) map.get("friendName"));
		if (map.containsKey("friendType"))
			friend.setFriendType((String) map.get("friendType"));
		if (map.containsKey("modifyFriendTime"))
			friend.setModifyFriendTime((String) map.get("modifyFriendTime"));
		if (map.containsKey("friendCustId"))
			friend.setFriendCustId((String) map.get("friendCustId"));
		if (map.containsKey("friendTypeSelf"))
			friend.setFriendTypeSelf((String) map.get("friendTypeSelf"));
		return friend;
	}

	public static Game transGame(Map<String, Object> map) {
		Game game = new Game();
		if (map.containsKey("custId"))
			game.setCustId((String) map.get("custId"));
		if (map.containsKey("gameId"))
			game.setGameId((String) map.get("gameId"));
		if (map.containsKey("gameNumber"))
			game.setGameNumber((String) map.get("gameNumber"));
		if (map.containsKey("activityId"))
			game.setActivityId((String) map.get("activityId"));
		return game;
	}

	public static Interest transInterest(Map<String, Object> map) {
		Interest interest = new Interest();
		if (map.containsKey("interestType"))
			interest.setInterestType((String) map.get("interestType"));
		if (map.containsKey("interestName"))
			interest.setInterestName((String) map.get("interestName"));
		if (map.containsKey("interestContent"))
			interest.setInterestContent((String) map.get("interestContent"));
		return interest;
	}

	public static Label transLabel(Map<String, Object> map) {
		Label label = new Label();
		if (map.containsKey("custId"))
			label.setCustId((String) map.get("custId"));
		if (map.containsKey("label"))
			label.setLabel((String) map.get("label"));
		if (map.containsKey("labelLevel"))
			label.setLabelLevel((String) map.get("labelLevel"));
		if (map.containsKey("modifyLableTime"))
			label.setLableTime((String) map.get("modifyLableTime"));
		if (map.containsKey("interestSelf"))
			label.setLabelSelf((String) map.get("interestSelf"));
		return label;
	}

	public static Menu transMenu(Map<String, Object> map) {
		Menu menu = new Menu();
		if (map.containsKey("menuId"))
			menu.setMenuId((String) map.get("menuId"));
		if (map.containsKey("menuName"))
			menu.setMenuName((String) map.get("menuName"));
		if (map.containsKey("menuDesc"))
			menu.setMenuDesc((String) map.get("menuDesc"));
		if (map.containsKey("menuSrc"))
			menu.setMenuSrc((String) map.get("menuSrc"));
		if (map.containsKey("menuType"))
			menu.setMenuType((String) map.get("menuType"));
		return menu;
	}

	public static Photo transPhoto(Map<String, Object> map) {
		Photo photo = new Photo();
		if (map.containsKey("photoId"))
			photo.setPhotoId((String) map.get("photoId"));
		if (map.containsKey("albumId"))
			photo.setAlbumId((String) map.get("albumId"));
		if (map.containsKey("photoName"))
			photo.setPhotoName((String) map.get("photoName"));
		if (map.containsKey("photoDesc"))
			photo.setPhotoDesc((String) map.get("photoDesc"));
		if (map.containsKey("photoSrc"))
			photo.setPhotoSrc((String) map.get("photoSrc"));
		if (map.containsKey("locationX"))
			photo.setLocationX((String) map.get("locationX"));
		if (map.containsKey("locationY"))
			photo.setLocationY((String) map.get("locationY"));
		return photo;
	}

	public static Question transQuestion(Map<String, Object> map) {
		Question question = new Question();
		if (map.containsKey("questionId"))
			question.setQuestionId((String) map.get("questionId"));
		if (map.containsKey("questionContent"))
			question.setQuestionContent((String) map.get("questionContent"));
		if (map.containsKey("questionType"))
			question.setQuestionType((String) map.get("questionType"));
		if (map.containsKey("questionAnswer"))
			question.setQuestionAnswer((String) map.get("questionAnswer"));
		if (map.containsKey("answer"))
			question.setAnswer((String) map.get("answer"));
		return question;
	}

	public static Reply transReply(Map<String, Object> map) {
		Reply reply = new Reply();
		if (map.containsKey("commentId"))
			reply.setCommentId((String) map.get("commentId"));
		if (map.containsKey("custId"))
			reply.setCustId((String) map.get("custId"));
		if (map.containsKey("replyId"))
			reply.setReplyId((String) map.get("replyId"));
		if (map.containsKey("replyContent"))
			reply.setReplyContent((String) map.get("replyContent"));
		if (map.containsKey("replyCustId"))
			reply.setReplyCustId((String) map.get("replyCustId"));
		if (map.containsKey("replyType"))
			reply.setReplyType((String) map.get("replyType"));
		return reply;
	}

	public static PhotoComment transPhotoComment(Map<String, Object> map) {
		PhotoComment Photocomment = new PhotoComment();
		if (map.containsKey("custId"))
			Photocomment.setCustId((String) map.get("custId"));
		if (map.containsKey("photoId"))
			Photocomment.setPhotoId((String) map.get("photoId"));
		if (map.containsKey("photoCommentId"))
			Photocomment.setPhotoCommentId((String) map.get("photoCommentId"));
		if (map.containsKey("photoCommentContent"))
			Photocomment.setPhotoCommentContent((String) map.get("photoCommentContent"));
		if (map.containsKey("photoCommentType"))
			Photocomment.setPhotoCommentType((String) map.get("photoCommentType"));
		return Photocomment;
	}

	public static PhotoReply transPhotoReply(Map<String, Object> map) {
		PhotoReply Photoreply = new PhotoReply();
		if (map.containsKey("custId"))
			Photoreply.setCustId((String) map.get("custId"));
		if (map.containsKey("photoReplyCustId"))
			Photoreply.setReplyCustId((String) map.get("photoReplyCustId"));
		if (map.containsKey("photoCommentId"))
			Photoreply.setPhotoCommentId((String) map.get("photoCommentId"));
		if (map.containsKey("photoReplyContent"))
			Photoreply.setPhotoReplyContent((String) map.get("photoReplyContent"));
		if (map.containsKey("photoReplyType"))
			Photoreply.setPhotoReplyType((String) map.get("photoReplyType"));
		return Photoreply;
	}

}
