package basics;

import java.util.Date;
import java.util.List;


public class Root {

	public String name;
	public String job;
	public String id;
	public Date createdAt;

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Root actual = (Root) obj;
		
		if(!actual.getName().equals(this.getName()) || !actual.getJob().equals(this.getJob())) 
			
			return false;
		
		return true;
	}

		private boolean name(Root r) {
		
		
		String actual = r.getName();
		String expected = this.getName();
		
		
		boolean result =false;
		
		
		if(actual.equals(expected)) {
			
			result = true;
		}
		else {
			result = false;
		}
		return result;
		
	}
		
		private boolean jobtitle(Root r) {
			
			String actual = r.getJob();
			String expected = this.getJob();
			boolean result = false;
			
			if(actual.equals(expected))
			{
			result = true;	
			}
			
			return result; 
			
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
