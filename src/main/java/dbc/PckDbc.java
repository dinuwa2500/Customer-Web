package dbc;

import java.util.List;

import entity.Package;

public interface PckDbc {
	
	
	public boolean AddPck(Package pck);
	
	public List<Package> getAllPck(int userId);
	
	public Package getPckById(int id);
	
	public boolean updateEditPck(Package p);
	
	public boolean deletePck(int id);
	

}
