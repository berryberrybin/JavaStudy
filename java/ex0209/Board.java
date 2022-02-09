package ex0209;

public class Board {
    private int no; // 글번호
    private String writer; // 작성자
    private String subject; // 제목
    private String contents; // 내용

    public Board() {
    }

    public Board(int no, String writer, String subject, String contents) {
        this.no = no;
        this.writer = writer;
        this.subject = subject;
        this.contents = contents;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Board{");
        sb.append("no=").append(no);
        sb.append(", writer='").append(writer).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", contents='").append(contents).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
