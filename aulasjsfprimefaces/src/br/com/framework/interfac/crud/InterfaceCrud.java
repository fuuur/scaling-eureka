package br.com.framework.interfac.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable{

	//Salva qualquer tipo de dado
	void save(T obj) throws Exception;	
 
	void persist(T obj) throws Exception;
 
	void saveOrUpdate(T obj) throws Exception;
	
	void update(T obj) throws Exception;
	
	void delete(T obj) throws Exception;
	
	
	//Salva ou Atualiza e retorna o objeto em estado persistente
	T merge (T obj) throws Exception;
	
	
	//Carrega lista de objetos da classe enviada
	List<T> findList(Class<T> objs) throws Exception;
	
	Object findById(Class<T> entidade, Long id) throws Exception;
	
	T findByPorId(Class<T> entidade, Long id) throws Exception;
	
	List<T> findListByQueryDinamica(String s) throws Exception;
	
	//update com HQL
	void executeUpdateQueryDinamica(String s) throws Exception;
	
	//Update com SQL pura
	void executeUpdateSQLDinamica(String s) throws Exception;
	
	void clearSession() throws Exception;
	
	//Retira objeto da sessão do hibernate
	void evict (Object obs) throws Exception;
	
	Session getSession() throws Exception;
	
	//recebe SQL e retorna lista de dados de qualquer objeto
	List<?> getListSQLDinamica(String sql) throws Exception;
	
	
	//JDBC do spring
	JdbcTemplate getJdbcTemplate();
	
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	
	SimpleJdbcInsert getSimpleJdbcInsert();
	
	
	long totalRegistro(String table) throws Exception;
	
	Query obterQuery(String query) throws Exception;
	
	
	//Consulta de cadastros por demanda (Carregar do tamanho da lista); JSF E PFaces
	List<T> findListByQueryDinamica (String query, int iniciaNoRegistro, int maximoResultado) throws Exception;
	
	
}
