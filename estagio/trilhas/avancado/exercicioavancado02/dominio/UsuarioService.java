package estagio.trilhas.avancado.exercicioavancado02.dominio;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioService{
    private static HashSet<Usuario> usuarios = new HashSet<>();

    public UsuarioService(HashSet<Usuario> usuarios) {
        UsuarioService.usuarios = usuarios;
    }

    public static void adicionarUsuario(Usuario usuario) throws DadoInvalidoException{
        String regex = "^Usuario\\{id=([0-9]+), nome='([A-Za-záéíóúâêôàã]+)', email='([a-z0-9._-]+@[a-z]+[.a-z]+)', idade=([0-9]+)}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(usuario.toString());

        if (matcher.matches()){
            usuarios.add(usuario);
        } else{
            throw new DadoInvalidoException("Dados Inválidos");
        }
    }

    public static Optional<HashSet<Usuario>> findByNome(String nome){
        Pattern pattern = Pattern.compile(nome);

        return findBy(usuario -> pattern.matcher(usuario.getNome()).find());
    }

    public   static Optional<HashSet<Usuario>> findByEmail(String email){
        Pattern pattern = Pattern.compile(email);

        return findBy(usuario -> pattern.matcher(usuario.getEmail()).find());
    }

    private static Optional<HashSet<Usuario>> findBy(Predicate<Usuario> predicate){
        HashSet<Usuario> usuariosFound = new HashSet<>();

        for(Usuario usuario : usuarios){
            if(predicate.test(usuario)){
                usuariosFound.add(usuario);
            }
        }

        return Optional.of(usuariosFound);
    }

    public static HashSet<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(HashSet<Usuario> usuarios) {
        UsuarioService.usuarios = usuarios;
    }
}
