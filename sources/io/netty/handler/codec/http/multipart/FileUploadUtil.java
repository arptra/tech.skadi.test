package io.netty.handler.codec.http.multipart;

final class FileUploadUtil {
    private FileUploadUtil() {
    }

    public static int compareTo(FileUpload fileUpload, FileUpload fileUpload2) {
        return fileUpload.getName().compareToIgnoreCase(fileUpload2.getName());
    }

    public static boolean equals(FileUpload fileUpload, FileUpload fileUpload2) {
        return fileUpload.getName().equalsIgnoreCase(fileUpload2.getName());
    }

    public static int hashCode(FileUpload fileUpload) {
        return fileUpload.getName().hashCode();
    }
}
