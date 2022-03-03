package boardExam;

public class ReplyDTO {
    private int replyNo;
    private String replyContent;
    private int boardNo;
    private String replyRegdate;

    ReplyDTO() {
    }

    public ReplyDTO(String replyContent, int boardNo) {
        this.replyContent = replyContent;
        this.boardNo = boardNo;
    }


    public ReplyDTO(int replyNo, String replyContent, int boardNo, String replyRegdate) {
        this(replyContent, boardNo);
        this.replyNo = replyNo;
        this.replyRegdate = replyRegdate;
    }

    public int getReplyNo() {
        return replyNo;
    }

    public void setReplyNo(int replyNo) {
        this.replyNo = replyNo;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public String getReplyRegdate() {
        return replyRegdate;
    }

    public void setReplyRegdate(String replyRegdate) {
        this.replyRegdate = replyRegdate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReplyDTO{");
        sb.append("replyNo=").append(replyNo);
        sb.append(", replyContentl='").append(replyContent).append('\'');
        sb.append(", boardNo=").append(boardNo);
        sb.append(", replyRegdate='").append(replyRegdate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
