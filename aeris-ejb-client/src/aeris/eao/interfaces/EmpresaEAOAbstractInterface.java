package aeris.eao.interfaces;

import java.util.List;
import javax.ejb.Local;
import aeris.entity.Empresa;

@Local
public abstract interface EmpresaEAOAbstractInterface {

	public abstract void criar(int empCod, String empNom);

	public abstract void atualizar(Empresa empresa);

	public abstract List<Empresa> buscarPorEmpCod(int empCod);

	public abstract List<Empresa> buscarPorEmpNom(String empNom);

}