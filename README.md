# Projeto Final Arquitetura Java [24E4_2] - Cadastro de Clínicas e Médicos

Este projeto faz parte da disciplina de **Arquitetura Java** e inclui um sistema de gerenciamento de clínicas e médicos utilizando Spring Boot.

### Estrutura do Projeto

- **`br.edu.infnet.alfredo.AlfredoApplication`**: Classe principal do projeto Spring Boot.
- **`br.edu.infnet.alfredo.Loader`**: Classe responsável por carregar dados iniciais a partir de um arquivo de texto.
- **Domínio**:
  - `Clinica`: Representa a clínica e contém uma lista de médicos.
  - `Medico`: Classe abstrata para representar médicos.
  - `Ginecologista`: Subclasse de `Medico` que representa médicos ginecologistas.
  - `Ortopedista`: Subclasse de `Medico` que representa médicos ortopedistas.
  - `Endereco`: Representa o endereço da clínica.
- **Serviço**:
  - `ClinicaService`: Classe que gerencia a inclusão e recuperação das clínicas cadastradas.
  - `MedicoService`: Classe que gerencia a inclusão e recuperação dos médicos cadastrados.
  - `GinecologistaService`: Classe que gerencia a inclusão e recuperação dos ginecologistas cadastrados.
  - `OrtopedistaService`: Classe que gerencia a inclusão e recuperação dos ortopedistas cadastrados.
  - `LocalizacaoService`: Classe que gerencia a busca de localização e endereço.

### Arquivo de Entrada

As clínicas e médicos são cadastrados automaticamente a partir do arquivo `files/clinicas.txt`. O arquivo deve seguir o seguinte formato:
C;nome;cnpj;telefone;cep 
G;nome;crm;preco;duracao;fazParto;colocaDiu
O;nome;crm;preco;duracao;subEspecialidade;fazCirurgia

Exemplo:
C;clínica da saúde da mulher;123123123123;(19)99999-9999;13073013
G;luana souza;15123;70;20;false;false
O;lucas antonio;45444;275;25;punho;true

### Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.7.5**
- **Maven**

## Autor

- **Alfredo Colito** - br.edu.infnet
