package luxoft.codingchallange.filesystem;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

public class File {
	private long size;
    private String name;
    private LocalDateTime timeCreated;
    private Permissions permission;
    
	public File(long size, String name, LocalDateTime timeCreated, Permissions permission) {
		this.size = size;
		this.name = name;
		this.timeCreated = timeCreated;
		this.permission = permission;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(LocalDateTime timeCreated) {
		this.timeCreated = timeCreated;
	}
	public Permissions getPermission() {
		return permission;
	}
	public void setPermission(Permissions permission) {
		this.permission = permission;
	}
	
	@Override
	public String toString() {
		return "File [size=" + size + ", name=" + name + ", timeCreated=" + timeCreated + ", permission=" + permission
				+ "]";
	}

	public boolean equals(File file) {
        if (this == file) {
            return true;
		}
        
        if (file == null || this.getClass() != file.getClass()) {
        	return false;
        }
 
        return size == file.size
        		&& name.equals(file.name) 
        		&& permission.equals(file.permission) 
        		&& timeCreated.equals(file.timeCreated);
    }
}
