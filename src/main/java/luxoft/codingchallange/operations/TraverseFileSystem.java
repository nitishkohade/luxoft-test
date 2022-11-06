package luxoft.codingchallange.operations;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

import luxoft.codingchallange.filesystem.File;
import luxoft.codingchallange.filesystem.Permissions;

public class TraverseFileSystem {
	
	private static boolean doesFileExistInFileSystem(File existingFile, File queryFile) {
		
//		LocalDate.of(2022, 10, 25).isBefore(ChronoLocalDate.from(file.getTimeCreated()))
		
		long existingFileSize = existingFile.getSize();
		long queryFileSize = queryFile.getSize();
		
		String existingFileName = existingFile.getName();
		String queryFileName = queryFile.getName();
		
		LocalDateTime existingFileDateTime = existingFile.getTimeCreated();
		LocalDateTime queryFileDateTime = queryFile.getTimeCreated();
		
		Permissions existingFilePermission = existingFile.getPermission();
		Permissions queryFilePermission = queryFile.getPermission();
		
		// Here I am accepting null or if value is <= 0 as true because user can choose not to query these fields and
		// if there are not null then they will be considered for processing since they are holding values
		boolean isFileSizeEqual = (queryFileSize <= 0 || existingFileSize == queryFileSize);
		boolean isFileNameEqual = (queryFileName == null || existingFileName.equals(queryFileName));
		boolean isFileDateTimePresent = (queryFileDateTime == null || queryFileDateTime.isBefore(existingFileDateTime));
		boolean isFilePermissionEqual = (queryFilePermission == null || existingFilePermission.equals(queryFilePermission));

		return isFileSizeEqual && isFileNameEqual && isFileDateTimePresent && isFilePermissionEqual;
	}
	
	public static List<File> queryFileInFilesystem(File[][] fileSystem, File queryFile) {
        if (fileSystem == null || fileSystem.length == 0) {
            return new ArrayList<File>();
        }
        
        int rowNum = fileSystem.length;
        int colNum = fileSystem[0].length;
        
        List<File> result = new ArrayList<File>();
        
        for (int i = 0; i < rowNum + colNum - 1; i++) {
   	
            int startX = (i <= (colNum - 1)) ? 0 : i - (rowNum - 1);
            int startY = (i <= (colNum - 1)) ? i : colNum - 1;
            
            int x = startX;
            int y = startY;
            
            while (x < rowNum && y >= 0) {               
               File currentFile = fileSystem[x][y];
               boolean isFilePresent = doesFileExistInFileSystem(currentFile, queryFile);
               
               if(isFilePresent) {
            	   result.add(currentFile);
               }
               
               x++;
               y--;
            }
        }
        
        return result;
    }
}
