
function Login() {
    return (

        <section>
            <div className="login-container">
                <h1>Login</h1>
                <form method="POST" action={"http://localhost:8080/api/login/funcionario"}>
                    <label>Email:</label>
                    <input type="email" name="username" placeholder="Digite seu email" required/>

                    <label>Senha:</label>
                    <input type="password" name="password" placeholder="Digite sua senha" required/>

                    <button type="submit">Entrar</button>
                </form>
            </div>
        </section>

    );
}

export default Login;
