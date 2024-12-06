<h1 align="center">
  🧭 bussola.dev MAP
</h1>

<div align="center">
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/clasSeven7/bussola-dev-map.svg" />
  
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/clasSeven7/bussola-dev-map.svg" />
  
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/clasSeven7/bussola-dev-map.svg" />

  <a href="https://github.com/clasSeven7/bussola-dev-map/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/clasSeven7/bussola-dev-map.svg" />
  </a>
  
  <a href="https://github.com/clasSeven7/bussola-dev-map/issues">
    <img alt="Repository issues" src="https://img.shields.io/github/issues/clasSeven7/bussola-dev-map.svg" />
  </a>
</div>

<div align="center">
  <img src=".github/preview.png" width="100%"/>
</div>

## 📖 Sobre

**bussola.dev MAP** é uma plataforma projetada para impulsionar o desenvolvimento de carreira e conhecimento técnico de desenvolvedores, abrangendo desde iniciantes até profissionais avançados. Além de permitir a criação de portfólios, colaboração em grupos temáticos e a obtenção de recomendações tecnológicas personalizadas, a plataforma oferece um vasto conjunto de recursos para orientar e informar os desenvolvedores, divididos em categorias de conhecimento – iniciante, intermediário e avançado – para facilitar o acesso a informações e práticas relevantes para cada nível de experiência.

### 📚 Contexto / Problema / Solução

- #### Contexto

No cenário atual, desenvolvedores enfrentam uma vasta gama de tecnologias e ferramentas disponíveis no mercado, dificultando a escolha de opções ideais para suas necessidades. Além disso, recrutadores buscam maneiras eficientes de encontrar talentos alinhados a projetos específicos.

- #### Problema

Desenvolvedores iniciantes carecem de direcionamento sobre quais linguagens aprender ou ferramentas usar. Profissionais intermediários e avançados enfrentam desafios para se manterem atualizados com as inovações do mercado. Recrutadores têm dificuldade em acessar portfólios qualificados para suas demandas.

- #### Solução

O **_bussola.dev_** oferece uma plataforma segmentada, onde desenvolvedores encontram orientação personalizada para tecnologias, ferramentas e linguagens ideais, além de criar conexões significativas com outros profissionais e recrutadores. A plataforma também auxilia no desenvolvimento de carreira por meio de recomendações baseadas em níveis de experiência e objetivos específicos.

---

### 💻 Requisitos

1. Cadastro e autenticação de usuários com controle de níveis de acesso (Desenvolvedores e Tutores).
2. Sistema de recomendação de tecnologias baseado no nível de experiência do usuário.
3. Criação e visualização de portfólios para desenvolvedores.
4. Sistema de avaliações e comparações de ferramentas/frameworks.
5. Atualizações regulares com notícias do universo da programação.
6. Grupos temáticos e discussões segmentadas por interesse e nível técnico.

---

### 🗂 Casos de Uso

1. _Usuário iniciante deseja aprender programação_

   - Navega por recomendações básicas para linguagens e frameworks de aprendizado rápido.
   - Consulta artigos e tutoriais recomendados para iniciantes.

2. _Desenvolvedor pleno busca aprimorar seu portfólio_

   - Avalia tecnologias intermediárias e compartilha projetos reais no portfólio.

3. Tutor procura usuários para uma vaga\_

   - Busca desenvolvedores com habilidades específicas por meio de portfólios filtrados.

4. _Grupo discute tendências em Inteligência Artificial_
   - Compartilhamento de insights e resolução colaborativa de problemas.

---

### 📐 Diagrama de Classes

> _Descrição_: O diagrama modela os principais componentes, como Usuário, Desenvolvedor, Portfólio, Arvore e Avaliação.

<img alt="Diagrama de Classes" src="/docs/image/diagrama_de_classes.jpeg" />

---

### 🔄 Diagrama de Atividades

> _Descrição_: O diagrama representa o fluxo principal de navegação do usuário desde o cadastro até a interação com o sistema de recomendações e grupos temáticos.

(Adicione o diagrama visual ou descreva o fluxo em detalhes.)

---

### 🧠 Padrão de Projeto Utilizado

### Padrão: Factory

O _Factory Pattern_ foi adotado para criar objetos relacionados às recomendações tecnológicas de forma flexível e modular.

#### Funcionamento

O padrão Factory fornece uma interface para a criação de objetos, permitindo que subclasses decidam qual classe instanciar. Por exemplo:

- A recomendação de tecnologias é gerada dinamicamente com base no nível do desenvolvedor (iniciante, intermediário ou avançado).
- O Factory avalia os parâmetros fornecidos e retorna a instância correspondente, como RecomendacaoIniciante, RecomendacaoIntermediario ou RecomendacaoAvancado.

#### Justificativa

- _Escalabilidade_: Facilita a adição de novos níveis ou categorias de recomendações sem alterar a lógica principal.
- _Reutilização_: Evita duplicação de código e promove modularidade.

---

## 🔍 Testes de Unidade e de Integração

### Testes de Unidade

Os testes verificam a lógica de componentes individuais, como:

- Criação de recomendações personalizadas.
- Sistema de avaliações de ferramentas e tecnologias.

### Testes de Integração

- Garantem que os módulos de autenticação, recomendações e portfólios funcionam de forma integrada.
- Simulam cenários reais, como um usuário navegando por tecnologias recomendadas e atualizando seu portfólio.

---

## 🔧 Mecânicas de Refatoração Aplicadas

1. _Redução de Duplicidade_: Código redundante foi refatorado para utilizar o Factory Pattern.
2. _Melhoria na Nomenclatura_: Nomes de classes e métodos foram ajustados para refletir melhor sua funcionalidade.
3. _Separação de Responsabilidades_: Componentes foram desacoplados para melhorar a organização e facilitar manutenção.

---

### 🛠 Frameworks e Tecnologias Utilizadas

#### 🚀 MAP

- _Backend_: Java (Nativo)
- _Frontend_: Swing (Java)

#### EXTRA - WEB

- _Frontend_: NEXT.js, CSS (Tailwind)
- _Backend_: Django REST Framework
- _Banco de Dados_: PostgreSQL
- _Autenticação_: JWT (JSON Web Tokens)
- _Ferramentas de Desenvolvimento_:
  - Next para construção do frontend
  - Axios para integração com APIs
  - Pytest para testes automatizados no backend
