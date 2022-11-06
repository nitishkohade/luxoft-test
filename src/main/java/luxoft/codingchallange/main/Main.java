package luxoft.codingchallange.main;

import java.time.LocalDateTime;
import java.util.List;
import luxoft.codingchallange.filesystem.File;
import luxoft.codingchallange.filesystem.FileSystem;
import luxoft.codingchallange.filesystem.Permissions;
import luxoft.codingchallange.operations.TraverseFileSystem;

public class Main {
    public static void main(String[] args){    	
    	File queryFile = new File(0, "file00", LocalDateTime.of(2022, 11, 1, 12, 12), Permissions.R);	
        List<File> list = TraverseFileSystem.queryFileInFilesystem(FileSystem.files, queryFile);
             
        for(File file: list) {
        	System.out.println(file);
        }
    }
}
