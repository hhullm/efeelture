package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.DateUtil;
import utils.MapTransEntity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.ActivityDaoImpl;
import dao.AlbumDaoImpl;
import dao.AttachmentDaoImpl;
import dao.CommentDaoImpl;
import dao.FriendDaoImpl;
import dao.InterestDaoImpl;
import dao.LabelDaoImpl;
import dao.PhotoCommentDaoImpl;
import dao.PhotoDaoImpl;
import dao.PhotoReplyDaoImpl;
import dao.QuestionDaoImpl;
import dao.ReplyDaoImpl;
import dao.UserDaoImpl;
import entity.Activity;
import entity.Album;
import entity.Attachment;
import entity.Comment;
import entity.Friend;
import entity.Interest;
import entity.Label;
import entity.Photo;
import entity.PhotoComment;
import entity.PhotoReply;
import entity.Question;
import entity.Reply;
import entity.User;

@SuppressWarnings("deprecation")
public class MobileAppServiceImpl implements MobileAppService {

	public String register(Map<String, Object> map) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			User user = MapTransEntity.transUser(map);
			User u = userDaoImpl.checkUser(user);
			String custId = u.getCustId();
			if (custId != null && !custId.equals(""))
				m.put("resultCode", "601");// 已被注册
			else {
				userDaoImpl.addUser(user);
				u.setPhoneNumber(user.getPhoneNumber());
				m.put("userList", userDaoImpl.selectUser(u));
				m.put("resultCode", "200");
				String headUrl = getAvatar(custId);
				if (headUrl != null && !headUrl.equals(""))
					m.put("headUrl", headUrl);
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "602");// 注册失败
		}
		return j.toJson(m);
	}

	@Override
	public String login(Map<String, Object> map) {
		Gson j = new Gson();
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			User user = MapTransEntity.transUser(map);
			user.setPhoneNumber(user.getCustName());
			user.setCustId(user.getCustName());
			user = userDaoImpl.loginUser(user);
			if (user.getCustId() == null || (user.getCustId()).equals(""))
				m.put("resultCode", "603");// 用户名密码不正确
			else {
				m = j.fromJson(j.toJson(user), new TypeToken<Map<String, Object>>() {
				}.getType());
				user = new User();
				user.setCustId((String) m.get("custId"));
				user.setLastLoginTime(DateUtil.getDate());
				userDaoImpl.modifyUser(user);
				m.put("resultCode", "200");
				String headUrl = getAvatar((String) m.get("custId"));
				if (headUrl != null && !headUrl.equals(""))
					m.put("headUrl", headUrl);
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "604");// 登录出现错误
		}
		return j.toJson(m);
	}

	@Override
	public String uploadHeadPic(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			AttachmentDaoImpl atta = new AttachmentDaoImpl();
			Attachment attachment = MapTransEntity.transAttachment(map);
			attachment.setAttaType("0");
			atta.addAttachment(attachment);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "605");// 上传头像失败
		}
		return j.toJson(m);
	}

	@Override
	public String eduAuth(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			if (uploadAtta(map) != null) {
				UserDaoImpl userImpl = new UserDaoImpl();
				User user = MapTransEntity.transUser(map);
				userImpl.modifyUser(user);
				m.put("resultCode", "200");
			} else
				m.put("resultCode", "606");// 实名认证不符合要求
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "000");
		}
		return j.toJson(m);
	}

	@Override
	public String modifyUser(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl userImpl = new UserDaoImpl();
			User user = MapTransEntity.transUser(map);
			userImpl.modifyUser(user);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "607");// 修改用户信息失败
		}
		return j.toJson(m);
	}

	@Override
	public String findAllLabel(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			InterestDaoImpl interestImpl = new InterestDaoImpl();
			LabelDaoImpl labelImpl = new LabelDaoImpl();
			Interest interest = MapTransEntity.transInterest(map);
			Label label = new Label();
			if (map.containsKey("custId"))
				label = MapTransEntity.transLabel(map);
			List<Interest> interestList = interestImpl.selectInterest(interest);
			List<Label> labelList = labelImpl.selectLabel(label);
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			if (interestList.size() > 0) {
				if (labelList.size() > 0) {
					for (int i = 0; i < interestList.size(); i++) {
						boolean flag = true;
						for (int k = 0; k < labelList.size(); k++) {
							if (((String) interestList.get(i).getInterestName()).equals(((String) labelList.get(k)
									.getLabelSelf()))) {
								flag = false;
								break;
							}
						}
						if (flag) {
							Map<String, Object> mm = j.fromJson(j.toJson(interestList.get(i)),
									new TypeToken<Map<String, Object>>() {
									}.getType());
							mapList.add(mm);
						}
					}
					m.put("interestList", mapList);
				} else
					m.put("interestList", interestList);
				m.put("resultCode", "200");
			} else
				m.put("resultCode", "608");// 标签库没有设置标签
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "609");// 标签库查询失败
		}
		return j.toJson(m);
	}


	@Override
	public String findLabel(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			LabelDaoImpl labelImpl = new LabelDaoImpl();
			Label label = MapTransEntity.transLabel(map);
			List<Label> labelList = labelImpl.selectLabel(label);
			if (labelList.size() > 0) {
				m.put("labelList", labelList);
				m.put("resultCode", "200");
			} else
				m.put("resultCode", "610");// 用户没有设置标签
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "611");// 用户标签查询失败
		}
		return j.toJson(m);
	}

	@Override
	public String addLabel(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			LabelDaoImpl labelImpl = new LabelDaoImpl();
			Label label = MapTransEntity.transLabel(map);
			labelImpl.addLabel(label);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "612");// 增加一个用户
		}
		return j.toJson(m);
	}

	@Override
	public String deleteLabel(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			LabelDaoImpl labelImpl = new LabelDaoImpl();
			Label label = MapTransEntity.transLabel(map);
			labelImpl.deleteLabel(label);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "613");// 删除一个标签
		}
		return j.toJson(m);
	}

	@Override
	public String findQuestion(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			QuestionDaoImpl questionImpl = new QuestionDaoImpl();
			Question question = MapTransEntity.transQuestion(map);
			List<Question> questionList = questionImpl.selectQuestion(question);
			if (questionList.size() > 0) {
				m.put("questionList", questionList);
				m.put("resultCode", "200");
			} else
				m.put("resul;tCode", "614");// 查找问题
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "615");// 问题查找失败
		}
		return j.toJson(m);
	}

	@Override
	public String publishActivity(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			String attaId = uploadAtta(map);
			if (attaId != null) {
				if (!attaId.equals(""))
					map.put("attaId", attaId);
				ActivityDaoImpl activityImpl = new ActivityDaoImpl();
				Activity activity = MapTransEntity.transActivity(map);
				activityImpl.addActivity(activity);
				m.put("resultCode", "200");
			} else
				m.put("resultCode", "616");// 上传附件失败
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "617");// 发布活动失败
		}
		return j.toJson(m);
	}

	@Override
	public String deleteActivity(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			ActivityDaoImpl activityImpl = new ActivityDaoImpl();
			CommentDaoImpl commentImpl = new CommentDaoImpl();
			ReplyDaoImpl replyImpl = new ReplyDaoImpl();
			Activity activity = MapTransEntity.transActivity(map);
			Comment comment = MapTransEntity.transComment(map);
			List<Comment> commentList = commentImpl.selectComment(comment);
			if (commentList.size() > 0) {
				for (int i = 0; i < commentList.size(); i++) {
					comment = commentList.get(i);
					Reply reply = new Reply();
					reply.setCommentId(comment.getCommentId());
					replyImpl.deleteReply(reply);
				}
				commentImpl.deleteComment(comment);
			}
			activityImpl.deleteActivity(activity);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "618");// 活动删除失败
		}
		return j.toJson(m);
	}

	@Override
	public String modifyActivity(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			ActivityDaoImpl activityImpl = new ActivityDaoImpl();
			Activity activity = MapTransEntity.transActivity(map);
			activityImpl.updateActivity(activity);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "619");// 修改活动信息失败
		}
		return j.toJson(m);
	}

	@Override
	public String findAllActivity(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			ActivityDaoImpl activityImpl = new ActivityDaoImpl();
			UserDaoImpl userImpl = new UserDaoImpl();
			Activity activity = MapTransEntity.transActivity(map);
			List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
			List<Activity> activityList = activityImpl.selectActivity(activity);
			if (activityList.size() > 0) {
				for (int i = 0; i < activityList.size(); i++) {
					Map<String, Object> mm = j.fromJson(j.toJson(activityList.get(i)),
							new TypeToken<Map<String, Object>>() {
							}.getType());
					User user = new User();
					user.setCustId((String) mm.get("custId"));
					user = userImpl.selectUser(user).get(0);
					mm.put("custName", user.getCustName());
					mm.put("custVip", user.getCustVip());
					String headUrl = getAvatar((String) mm.get("custId"));
					if (headUrl != null && !headUrl.equals(""))
						mm.put("headUrl", headUrl);
					listMap.add(mm);
				}
				m.put("activityList", listMap);
			} else
				m.put("resultCode", "620");// 没有活动
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "621");// 活动查询失败
		}
		return j.toJson(m);
	}

	@Override
	public String findActivity(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
			CommentDaoImpl commentImpl = new CommentDaoImpl();
			UserDaoImpl userImpl = new UserDaoImpl();
			ReplyDaoImpl replyImpl = new ReplyDaoImpl();
			ActivityDaoImpl activityImpl = new ActivityDaoImpl();
			/*
			 * 获取活动的评论及回复等信息
			 */
			Comment comment = MapTransEntity.transComment(map);
			List<Comment> commentList = commentImpl.selectComment(comment);
			if (commentList != null && commentList.size() > 0) {
				for (int i = 0; i < commentList.size(); i++) {
					Map<String, Object> mm = j.fromJson(j.toJson(commentList.get(i)),
							new TypeToken<Map<String, Object>>() {
							}.getType());
					User user = new User();
					user.setCustId((String) mm.get("custId"));
					user = userImpl.selectUser(user).get(0);
					mm.put("custName", user.getCustName());
					mm.put("custVip", user.getCustVip());
					String headUrl = getAvatar((String) mm.get("custId"));
					if (headUrl != null && !headUrl.equals(""))
						mm.put("headUrl", headUrl);
					Reply reply = new Reply();
					reply.setCommentId(commentList.get(i).getCommentId());
					List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
					List<Reply> replyList = replyImpl.selectReply(reply);
					if (replyList != null && replyList.size() > 0) {
						for (int k = 0; k < replyList.size(); k++) {
							Map<String, Object> mL = j.fromJson(j.toJson(replyList.get(k)),
									new TypeToken<Map<String, Object>>() {
									}.getType());
							user = new User();
							user.setCustId((String) mL.get("custId"));
							user = userImpl.selectUser(user).get(0);
							mL.put("custName", user.getCustName());
							user = new User();
							user.setCustId((String) mL.get("replyCustId"));
							user = userImpl.selectUser(user).get(0);
							mL.put("replyCustName", user.getCustName());
							mList.add(mL);
						}
					}
					mm.put("replyList", mList);
					listMap.add(mm);
				}
				m.put("listMap", listMap);
			}
			/*
			 * 获取活动的附件信息
			 */
			/*
			 * List<Map<String, Object>> attaList = new ArrayList<Map<String,
			 * Object>>(); String attaId = activity.getAttaId(); if (attaId !=
			 * null & !attaId.equals("")) { String[] atta = attaId.split("@");
			 * for (int i = 0; i < atta.length - 1; i++) { Attachment attachment
			 * = new Attachment(); attachment.setAttaId(atta[i]); Attachment
			 * attaL = attaImpl.selectAttachment(attachment).get(0); Map<String,
			 * Object> mm = j.fromJson(j.toJson(attaL), new
			 * TypeToken<Map<String, Object>>() { }.getType());
			 * attaList.add(mm); } m.put("attaList", attaList); }
			 */

			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "622");// 查找活动信息失败
		}
		return j.toJson(m);
	}

	@Override
	public String addFriend(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			FriendDaoImpl friendImpl = new FriendDaoImpl();
			Friend friend = MapTransEntity.transFriend(map);
			friendImpl.addFriend(friend);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "623");// 增加朋友失败
		}
		return j.toJson(m);
	}

	@Override
	public String deleteFriend(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			FriendDaoImpl friendImpl = new FriendDaoImpl();
			Friend friend = MapTransEntity.transFriend(map);
			friendImpl.deleteFriend(friend);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "624");// 删除朋友失败
		}
		return j.toJson(m);
	}

	@Override
	public String modifyFriend(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			FriendDaoImpl friendImpl = new FriendDaoImpl();
			Friend friend = MapTransEntity.transFriend(map);
			friendImpl.updateFriend(friend);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "625");// 修改朋友信息失败
		}
		return j.toJson(m);
	}

	@Override
	public String findAllFriend(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			FriendDaoImpl friendImpl = new FriendDaoImpl();
			Friend friend = MapTransEntity.transFriend(map);
			List<Friend> friendList = friendImpl.selectFriend(friend);
			if (friendList.size() > 0) {
				List<Map<String, Object>> fList = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < friendList.size(); i++) {
					String custId = friendList.get(i).getFriendCustId();
					Map<String, Object> mm = j.fromJson(j.toJson(friendList.get(i)),
							new TypeToken<Map<String, Object>>() {
							}.getType());
					String headUrl = getAvatar(custId);
					if (headUrl != null && !headUrl.equals(""))
						mm.put("headUrl", headUrl);
					fList.add(mm);
				}
				m.put("friendList", fList);

				m.put("resultCode", "200");
			} else
				m.put("resultCode", "626");// 没有朋友列表
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "627");// 朋友列表查询失败
		}
		return j.toJson(m);
	}

	@Override
	public String addAlbum(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			AlbumDaoImpl albumImpl = new AlbumDaoImpl();
			Album album = MapTransEntity.transAlbum(map);
			albumImpl.addAlbum(album);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "628");// 增加相册失败
		}
		return j.toJson(m);
	}

	@Override
	public String deleteAlbum(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			AlbumDaoImpl albumImpl = new AlbumDaoImpl();
			PhotoDaoImpl photoImpl = new PhotoDaoImpl();
			Album album = MapTransEntity.transAlbum(map);
			Photo photo = MapTransEntity.transPhoto(map);
			photoImpl.deletePhoto(photo);
			albumImpl.deleteAlbum(album);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "629");// 删除相册失败
		}
		return j.toJson(m);
	}

	@Override
	public String modifyAlbum(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			AlbumDaoImpl albumImpl = new AlbumDaoImpl();
			Album album = MapTransEntity.transAlbum(map);
			albumImpl.updateAlbum(album);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "630");// 修改相册信息失败
		}
		return j.toJson(m);
	}

	@Override
	public String findAlbum(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			AlbumDaoImpl albumImpl = new AlbumDaoImpl();
			UserDaoImpl userImpl = new UserDaoImpl();
			Album album = MapTransEntity.transAlbum(map);
			List<Album> albumList = albumImpl.selectAlbum(album);
			if (albumList.size() > 0) {
				User user = new User();
				user.setCustId(albumList.get(0).getCustId());
				user = userImpl.selectUser(user).get(0);
				m.put("custId", user.getCustId());
				m.put("custName", user.getCustName());
				m.put("custVip", user.getCustVip());
				m.put("albumList", albumList);
				String headUrl = getAvatar((String) m.get("custId"));
				if (headUrl != null && !headUrl.equals(""))
					m.put("headUrl", headUrl);
				m.put("resultCode", "200");
			} else
				m.put("resultCode", "631");// 没有相册
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "632");// 查找相册失败
		}
		return j.toJson(m);
	}

	@Override
	public String addPhoto(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			PhotoDaoImpl photoImpl = new PhotoDaoImpl();
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> photoList = (List<Map<String, Object>>) map.get("photoList");
			if (photoList.size() > 0) {
				for (int i = 0; i < photoList.size(); i++) {
					Photo photo = MapTransEntity.transPhoto(photoList.get(i));
					photo.setAlbumId((String) map.get("albumId"));
					photoImpl.addPhoto(photo);
				}
				m.put("resultCode", "200");
			} else
				m.put("resultCode", "633");// 没有上传成功
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "634");// 相册批量失败
		}
		return j.toJson(m);
	}

	@Override
	public String deletePhoto(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			PhotoDaoImpl photoImpl = new PhotoDaoImpl();
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> photoList = (List<Map<String, Object>>) map.get("photoList");
			if (photoList.size() > 0) {
				for (int i = 0; i < photoList.size(); i++) {
					Photo photo = MapTransEntity.transPhoto(photoList.get(i));
					photoImpl.deletePhoto(photo);
				}
				m.put("resultCode", "200");
			} else
				m.put("resultCode", "635");// 没有批量选择
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "636");// 相册批量删除失败
		}
		return j.toJson(m);
	}

	@Override
	public String modifyPhoto(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			PhotoDaoImpl photoImpl = new PhotoDaoImpl();
			Photo photo = MapTransEntity.transPhoto(map);
			photoImpl.updatePhoto(photo);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "637");// 修改相片信息
		}
		return j.toJson(m);
	}

	@Override
	public String findPhoto(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			PhotoDaoImpl photoImpl = new PhotoDaoImpl();
			Photo photo = MapTransEntity.transPhoto(map);
			List<Photo> photoList = photoImpl.selectPhoto(photo);
			if (photoList.size() > 0) {
				m.put("photoList", photoList);
				m.put("resultCode", "200");
			} else
				m.put("resultCode", "638");// 查不到相片
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "639");// 相片查询失败
		}
		return j.toJson(m);
	}

	@Override
	public String messageCode(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {

			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "640");// 验证码发送失败
		}
		return j.toJson(m);
	}

	@Override
	public String modifyPassword(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl userImpl = new UserDaoImpl();
			User user = new User();
			user.setCustId((String) map.get("custId"));
			user.setPhoneNumber((String) map.get("phoneNumber"));
			user.setCustName("");
			user.setPassword((String) map.get("oldPassword"));
			user = userImpl.loginUser(user);
			if (user.getCustId() != null && !user.getCustId().equals("")) {
				user = new User();
				user.setCustId((String) map.get("custId"));
				user.setPassword((String) map.get("newPassword"));
				userImpl.modifyUser(user);
				m.put("resultCode", "200");
			} else
				m.put("resultCode", "641");// 原密码错误
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "642");// 修改密码失败
		}
		return j.toJson(m);
	}

	@Override
	public String addComment(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			CommentDaoImpl commentImpl = new CommentDaoImpl();
			Comment comment = MapTransEntity.transComment(map);
			commentImpl.addComment(comment);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "643");// 增加评论失败、点赞失败、参与失败
		}
		return j.toJson(m);
	}

	@Override
	public String deleteComment(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			CommentDaoImpl commentImpl = new CommentDaoImpl();
			ReplyDaoImpl replyImpl = new ReplyDaoImpl();
			Comment comment = MapTransEntity.transComment(map);
			Reply reply = MapTransEntity.transReply(map);
			commentImpl.deleteComment(comment);
			replyImpl.deleteReply(reply);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "644");// 删除评论
		}
		return j.toJson(m);
	}

	@Override
	public String addReply(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			ReplyDaoImpl replyImpl = new ReplyDaoImpl();
			Reply reply = MapTransEntity.transReply(map);
			replyImpl.addReply(reply);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "645");// 增加一个回复
		}
		return j.toJson(m);
	}

	@Override
	public String deleteReply(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			ReplyDaoImpl replyImpl = new ReplyDaoImpl();
			Reply reply = MapTransEntity.transReply(map);
			replyImpl.deleteReply(reply);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "646");// 删除回复
		}
		return j.toJson(m);
	}

	@Override
	public String queryInfo(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl userImpl = new UserDaoImpl();
			User user = new User();
			user.setCustId((String) map.get("custName"));
			user.setCustName((String) map.get("custName"));
			user.setPhoneNumber((String) map.get("custName"));
			List<User> userList = userImpl.selectUser(user);
			if (userList.size() > 0) {
				List<Map<String, Object>> uList = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < userList.size(); i++) {
					Map<String, Object> mm = j.fromJson(j.toJson(userList.get(i)),
							new TypeToken<Map<String, Object>>() {
							}.getType());
					String headUrl = getAvatar((String) mm.get("custId"));
					if (headUrl != null && !headUrl.equals(""))
						mm.put("headUrl", headUrl);
					uList.add(mm);
				}
				m.put("userList", uList);
				m.put("resultCode", "200");
			} else
				m.put("resultCode", "647");// 没有指定用户
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "648");// 查询失败
		}
		return j.toJson(m);
	}

	@Override
	public String queryLocation(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl userImpl = new UserDaoImpl();
			User user = MapTransEntity.transUser(map);
			List<User> userList = userImpl.selectUser(user);
			if (userList.size() > 0) {
				List<Map<String, Object>> uList = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < userList.size(); i++) {
					Map<String, Object> mm = j.fromJson(j.toJson(userList.get(i)),
							new TypeToken<Map<String, Object>>() {
							}.getType());
					String headUrl = getAvatar((String) mm.get("custId"));
					if (headUrl != null && !headUrl.equals(""))
						mm.put("headUrl", headUrl);
					uList.add(mm);
				}
				m.put("userList", uList);
				m.put("resultCode", "200");
			} else
				m.put("resultCode", "649");// 没有指定用户
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "650");// 查询失败
		}
		return j.toJson(m);
	}

	@Override
	public String queryFuzzy(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl userImpl = new UserDaoImpl();
			User user = new User();
			user.setCustStatus((String) map.get("queryContent"));
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "653");// 验证码发送失败
		}
		return j.toJson(m);
	}

	@Override
	public String resertPassword(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			UserDaoImpl userImpl = new UserDaoImpl();
			User user = MapTransEntity.transUser(map);
			user = userImpl.checkUser(user);
			if (user.getCustId() != null && !user.getCustId().equals("")) {
				user.setPassword((String) map.get("newPassword"));
				userImpl.modifyUser(user);
				m.put("resultCode", "200");
			} else
				m.put("resultCode", "655");// 请确认手机号码是否存在
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "656");// 重置密码错误
		}
		return j.toJson(m);
	}

	@Override
	public String addPhotoComment(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			PhotoCommentDaoImpl photoCommentImpl = new PhotoCommentDaoImpl();
			PhotoComment photoComment = MapTransEntity.transPhotoComment(map);
			photoCommentImpl.addPhotoComment(photoComment);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "645");// 增加一个回复
		}
		return j.toJson(m);
	}

	@Override
	public String deletePhotoComment(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			PhotoCommentDaoImpl photoCommentImpl = new PhotoCommentDaoImpl();
			PhotoReplyDaoImpl photoReplyImpl = new PhotoReplyDaoImpl();
			PhotoComment photoComment = MapTransEntity.transPhotoComment(map);
			photoCommentImpl.deletePhotoComment(photoComment);
			PhotoReply photoReply = MapTransEntity.transPhotoReply(map);
			photoReplyImpl.deletePhotoReply(photoReply);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "645");// 增加一个回复
		}
		return j.toJson(m);
	}

	@Override
	public String addPhotoReply(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			PhotoReplyDaoImpl photoReplyImpl = new PhotoReplyDaoImpl();
			PhotoReply photoReply = MapTransEntity.transPhotoReply(map);
			photoReplyImpl.addPhotoReply(photoReply);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "645");// 增加一个回复
		}
		return j.toJson(m);
	}

	@Override
	public String deletePhotoReply(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			PhotoReplyDaoImpl photoReplyImpl = new PhotoReplyDaoImpl();
			PhotoReply photoReply = MapTransEntity.transPhotoReply(map);
			photoReplyImpl.deletePhotoReply(photoReply);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "645");// 增加一个回复
		}
		return j.toJson(m);
	}

	@Override
	public String queryPhotoInfo(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			PhotoDaoImpl photoImpl = new PhotoDaoImpl();
			UserDaoImpl userImpl = new UserDaoImpl();
			PhotoCommentDaoImpl photoCommentImpl = new PhotoCommentDaoImpl();
			PhotoReplyDaoImpl photoReplyImpl = new PhotoReplyDaoImpl();
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			Photo photo = MapTransEntity.transPhoto(map);
			photo = photoImpl.selectPhoto(photo).get(0);
			m = j.fromJson(j.toJson(photo), new TypeToken<Map<String, Object>>() {
			}.getType());
			PhotoComment photoComment = MapTransEntity.transPhotoComment(map);
			List<PhotoComment> photoCommentList = photoCommentImpl.selectPhotoComment(photoComment);
			if (photoCommentList != null && photoCommentList.size() > 0) {
				for (int i = 0; i < photoCommentList.size(); i++) {
					Map<String, Object> mm = j.fromJson(j.toJson(photoCommentList.get(i)),
							new TypeToken<Map<String, Object>>() {
							}.getType());
					User user = new User();
					user.setCustId((String) mm.get("custId"));
					user = userImpl.selectUser(user).get(0);
					mm.put("custName", user.getCustName());
					mm.put("custVip", user.getCustVip());
					String headUrl = getAvatar((String) mm.get("custId"));
					if (headUrl != null && !headUrl.equals(""))
						mm.put("headUrl", headUrl);
					String commentId = photoCommentList.get(i).getPhotoCommentId();
					PhotoReply photoReply = new PhotoReply();
					photoReply.setPhotoCommentId(commentId);
					List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
					List<PhotoReply> photoReplyList = photoReplyImpl.selectPhotoReply(photoReply);
					if (photoReplyList != null && photoReplyList.size() > 0) {
						for (int k = 0; k < photoReplyList.size(); k++) {
							Map<String, Object> mL = j.fromJson(j.toJson(photoReplyList.get(k)),
									new TypeToken<Map<String, Object>>() {
									}.getType());
							user = new User();
							user.setCustId((String) mL.get("custId"));
							user = userImpl.selectUser(user).get(0);
							mL.put("custName", user.getCustName());
							user = new User();
							user.setCustId((String) mL.get("replyCustId"));
							user = userImpl.selectUser(user).get(0);
							mL.put("replyCustName", user.getCustName());
							mList.add(mL);
						}
					}
					mm.put("photoReplyList", mList);
					mapList.add(mm);
				}
			}
			m.put("mapList", mapList);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "645");// 增加一个回复
		}
		return j.toJson(m);
	}

	private String uploadAtta(Map<String, Object> map) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> attaList = (List<Map<String, Object>>) map.get("attaList");
		String attaId = "";
		try {
			if (attaList.size() > 0) {
				AttachmentDaoImpl attaImpl = new AttachmentDaoImpl();
				for (int i = 0; i < attaList.size(); i++) {
					String custId = (String) attaList.get(i).get("custId");
					String attaName = (String) attaList.get(i).get("attaName");
					String attaType = (String) attaList.get(i).get("attaType");
					String attaSrc = (String) attaList.get(i).get("attaSrc");
					Attachment atta = new Attachment();
					if (custId != null && !custId.equals(""))
						atta.setCustId(custId);
					if (attaName != null && !attaName.equals(""))
						atta.setAttaName(attaName);
					if (attaType != null && !attaType.equals(""))
						atta.setAttaType(attaType);
					if (attaSrc != null && !attaSrc.equals(""))
						atta.setAttaSrc(attaSrc);
					attaImpl.addAttachment(atta);
					attaId += atta.getAttaId() + "@";
				}
				return attaId;
			}
			return attaId;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String addCollectionActivity(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			ActivityDaoImpl activityImpl = new ActivityDaoImpl();
			Activity activity = MapTransEntity.transActivity(map);
			activityImpl.addActivity(activity);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "645");
		}
		return j.toJson(m);
	}

	public String deleteCollectionActivity(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			ActivityDaoImpl activityImpl = new ActivityDaoImpl();
			Activity activity = MapTransEntity.transActivity(map);
			activityImpl.deleteActivity(activity);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "645");
		}
		return j.toJson(m);
	}
	
	public String selectCollectionActivity(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			ActivityDaoImpl activityImpl = new ActivityDaoImpl();
			Activity activity = MapTransEntity.transActivity(map);
			activityImpl.selectActivity(activity);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "645");
		}
		return j.toJson(m);
	}
	
	public String addCollectionPhoto(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			PhotoDaoImpl photoImpl = new PhotoDaoImpl();
			Photo photo = MapTransEntity.transPhoto(map);
			photoImpl.addPhoto(photo);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "645");
		}
		return j.toJson(m);
	}

	
	public String deleteCollectionPhoto(Map<String, Object> map) {
		Map<String, Object> m = new HashMap<String, Object>();
		Gson j = new Gson();
		try {
			PhotoDaoImpl photoImpl = new PhotoDaoImpl();
			Photo photo = MapTransEntity.transPhoto(map);
			photoImpl.deletePhoto(photo);
			m.put("resultCode", "200");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("resultCode", "645");
		}
		return j.toJson(m);
	}

	private String getAvatar(String custId) {
		AttachmentDaoImpl attaImpl = new AttachmentDaoImpl();
		Attachment atta = new Attachment();
		atta.setCustId(custId);
		atta.setAttaType("0");
		List<Attachment> attaList = attaImpl.selectAttachment(atta);
		if (attaList != null && attaList.size() > 0)
			atta = attaList.get(0);
		return atta.getAttaSrc();
	}
}
