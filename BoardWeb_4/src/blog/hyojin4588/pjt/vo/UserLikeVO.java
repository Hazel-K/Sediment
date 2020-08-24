package blog.hyojin4588.pjt.vo;

public class UserLikeVO {
	
	private int i_board;
	private int i_user;
	private String r_dt;
	private int like;
	
	public int getI_board() {
		return i_board;
	}
	public void setI_board(int i_board) {
		this.i_board = i_board;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	
}
