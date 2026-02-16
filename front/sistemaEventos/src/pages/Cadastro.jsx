
function Cadastro() {
    return (

        <section>
            <div className="login-container">
                <h1>Login</h1>
                <form>
                    <label>Email:</label>
                    <input type="email" name="username" placeholder="Digite seu email" />

                    <label>Senha:</label>
                    <input type="password" name="password" placeholder="Digite sua senha" />

                    <button type="submit">Entrar</button>
                </form>
            </div>
        </section>

    );
}

export default Cadastro;