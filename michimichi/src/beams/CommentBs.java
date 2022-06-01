package beams;

public class CommentBs {

	private int comment_id;
	private String name;
	private String comment;
	private String post_time;

	//コンストラクタの定義
		public CommentBs(){}

		public CommentBs(int comment_id, String name, String comment, String post_time){

			this.comment_id = comment_id;
			this.name = name;
			this.comment = comment;
			this.post_time = post_time;

		}

		public int getComment_id() {
			return comment_id;
		}

		public void setComment_id(int comment_id) {
			this.comment_id = comment_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getPost_time() {
			return post_time;
		}

		public void setPost_time(String post_time) {
			this.post_time = post_time;
		}



}
