Controle de Estoque A3

Alunos: Erik Martins, Vitor Fabiano da Silva


Sistema de controle de estoque voltado para empresas comerciais, com funcionalidades como cadastro, consulta, alteração e exclusão de produtos, reajuste de preços e geração de relatórios.



🚀 Tecnologias Utilizadas
Linguagem: Java

IDE: NetBeans / IntelliJ

Banco de Dados: MySQL



📁 Estrutura do Projeto
dao/ – Acesso ao banco de dados (ex: CategoriaDAO, ProdutoDAO, ConexaoDAO)

modelo/ – Classes que representam os dados (Produto, Categoria)

servico/ – Regras de negócio (ex: movimentação de estoque)

visao/ – Interface gráfica (cadastros, relatórios, etc.)

principal/ – Classe principal que inicializa o sistema



✅ Funcionalidades
Cadastro, consulta, edição e remoção de produtos

Organização por categorias (limpeza, enlatados, vegetais, etc.)

Controle de quantidade em estoque

Reajuste de preços com base em percentual

Relatórios para apoio na gestão e tomada de decisão



🔧 Como Rodar o Projeto
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/silvavitooor/ControleDeEstoqueA3.git
Importe o projeto em sua IDE Java (NetBeans ou IntelliJ)



Configure o banco de dados MySQL:

Crie um banco com o nome estoque_db

Execute o script de criação das tabelas (caso exista)

Atualize as credenciais no arquivo de conexão (ConexaoDAO.java)

Compile e execute a classe principal



🤝 Contribuições
Contribuições são bem-vindas! Sinta-se livre para abrir issues ou pull requests.

📄 Licença
Este projeto está sob a licença MIT – consulte o arquivo LICENSE para detalhes.

