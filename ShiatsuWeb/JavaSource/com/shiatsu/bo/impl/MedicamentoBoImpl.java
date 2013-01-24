package com.shiatsu.bo.impl;

import java.util.Date;
import java.util.List;

import com.shiatsu.bo.MedicamentoBo;
import com.shiatsu.dao.MedicamentoDao;
import com.shiatsu.domain.Medicamento;
import com.shiatsu.web.bundles.Bundle;
import com.shiatzu.util.Utilidades;
import com.utilidades.business.BusinessErrorHelper;
import com.utilidades.business.BusinessObjectHelper;

public class MedicamentoBoImpl extends BusinessObjectHelper implements MedicamentoBo {

	private MedicamentoDao medicamentoDao;
	
	/**
	 * @param pMedicamentoDao the pMedicamentoDao to set
	 */
	public void setMedicamentoDao(MedicamentoDao MedicamentoDao) {
		this.medicamentoDao = MedicamentoDao;
	}

	@Override
	public void agregar(Medicamento medicamento) throws BusinessErrorHelper {
		try{
			 if(!this.existe(medicamento)){
			 	medicamento.setPvObUsuario(Utilidades.getUsuario());
			 	medicamento.setPvDaModifica(new Date());
				 this.medicamentoDao.agregar(medicamento);
			 }else{
				 throw new Exception(Bundle.rcs.getString("existe"));
			 }
		}catch (Exception e) {
           e.printStackTrace();
           this.addError("MedicamentoBo.agregar",e.getMessage() );
           this.throwBussinessError();
		}
		
	}

	@Override
	public void modificar(Medicamento medicamento) throws BusinessErrorHelper {
		try{
			 if(this.medicamentoDao.existe(medicamento)){
				 medicamento.setPvDaModifica(new Date());
				 this.medicamentoDao.modificar(medicamento);
	         }else{ 
	        	this.addError("MedicamentoBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
         e.printStackTrace();
         this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
         this.throwBussinessError();
		}
	}

	@Override
	public void eliminar(Medicamento medicamento) throws BusinessErrorHelper {
		try{
			 if(this.medicamentoDao.existe(medicamento)){
				 this.medicamentoDao.eliminar(medicamento);
	         }else{ 
	        	this.addError("MedicamentoBo.modificar", Bundle.rcs.getString("noExiste"));
	         }
		}catch (Exception e) {
        e.printStackTrace();
        this.addError(null, Bundle.rcs.getString("error") + e.getMessage());
        this.throwBussinessError();
		}
	}

	@Override
	public Medicamento buscar(Medicamento medicamento) { 
		return this.medicamentoDao.buscar(medicamento);
	}

	@Override
	public boolean existe(Medicamento medicamento) {
		return this.medicamentoDao.existe(medicamento);
	}

	@Override
	public List<Medicamento> getMedicamento() {
		return this.medicamentoDao.getMedicamento();
	}

	@Override
	public List<Medicamento> getMedicamento(Medicamento medicamento) {
		return this.medicamentoDao.getMedicamento(medicamento);
	}

}
