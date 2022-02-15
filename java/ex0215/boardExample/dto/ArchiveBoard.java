package ex0215.boardExample.dto;

public class ArchiveBoard extends Board {
    private String fileName;
    private int fileSize;

    public ArchiveBoard() {
    }

    public ArchiveBoard(int no, String subject, String writer, String content, String date, String fileName, int fileSize) {
        super(no, subject, writer, content, date);
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", 첨부파일 이름 : ").append(fileName);
        sb.append(", 파일 용량 : ").append(fileSize);
        return sb.toString();
    }
}
