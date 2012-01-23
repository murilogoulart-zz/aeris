package aeris.managedbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ejb.EJB;

import aeris.eao.interfaces.EmpresaEAORemote;
import aeris.entity.Empresa;

@ManagedBean(name = "empresaManagedBean")
@RequestScoped
public class EmpresaManagedBean {
	@EJB
	private EmpresaEAORemote empresaEAO;
	private int empCod;
	private String empNom;

	public int getEmpCod() {
		return empCod;
	}

	public void setEmpCod(int empCod) {
		this.empCod = empCod;
	}

	public String getEmpNom() {
		return empNom;
	}

	public void setEmpNom(String empNom) {
		this.empNom = empNom;
	}

	public String inserir() {
		String resultado_inserir = "cadastro_empresa_sucesso";
		empresaEAO.criar(empCod, empNom);
		return resultado_inserir;
	}

	public String buscarPorEmpCod() {
		List<Empresa> empresas = empresaEAO.buscarPorEmpCod(empCod);
		for (Empresa empresa : empresas) {
			this.empCod = empresa.getEmpCod();
			this.empNom = empresa.getEmpNom();
			break;
		}
		String resultado_busca = "consulta_empresa_sucesso";
		return resultado_busca;
	}

	public String buscarPorEmpNom() {
		List<Empresa> empresas = empresaEAO.buscarPorEmpNom(empNom);
		for (Empresa empresa : empresas) {
			this.empCod = empresa.getEmpCod();
			this.empNom = empresa.getEmpNom();
			break;
		}
		String resultado_busca = "consulta_empresa_sucesso";
		return resultado_busca;
	}
}