package login;

public class Usuario {
	
	private int id;
	private String usuario;
	private String senha;
	//Construtor
	public Usuario() {}
	
	public Usuario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	//getters and setters
	public int getId() {return id; }
	public void setID(int id ) { this.id = id; }
	
	public String getUsuario() { return usuario; }
	public void setUsuario(String USUARIO) {this.usuario = usuario; }
	
	public String getSenha( ) { return senha;}
	public void setSenha(String senha) {this.senha = senha; }
	}