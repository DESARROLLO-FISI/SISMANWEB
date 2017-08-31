package pe.edu.sistemas.sismanweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sismanweb.dao.PlanDAO;
import pe.edu.sistemas.sismanweb.domain.Plan;

@Service
public class PlanService {

	@Autowired
	PlanDAO planDao;
	
	public List<Plan> obtenerPlanes(){
		return planDao.findAll();
	}
	
	public Plan obtenerPlanXID(Integer idPlan){
		return planDao.findById(idPlan);
	}
	
}
