# RESTA-UM-INE5608
projeto implementado para a disciplina INE5608

## Especificação de requisitos
**Projeto:** Resta Um
####Especificação de Requisitos de Software:
  - Versão 1.0
  - 03/04/2015

|Versão|     Autor(es)     |   Data   |                   Ação                 |
|------|-------------------|----------|----------------------------------------|
| 1.0  |Thaise Santos Souza|03/04/2015|Início do desenvolvimento dos requisitos|

####Conteúdo:
  1. Introdução
  2. Visão geral
  3. Requisitos de software

####Introdução:
Este documento específica os requisitos de um jogo "Resta Um" adaptado para dois jogadores, na modalidade "em turnos", que será desenvolvido como um programa de computador.
Referências: 
 [regras do jogo](http://pt.wikipedia.org/wiki/Resta_um)

####Visão Geral:
**Arquitetura do programa:** programa orientado a objetos, cliente-servidor
#####Premissas de desenvolvimento:
  - O programa deve apresentar uma interface gráfica bidimensional
  - O programa deve ser implementado em Java, devendo executar em qualquer plataforma que disponha da máquina virtual Java
 
####Requisitos de software:
 **Requisitos Funcionais:**

|Cód.   |               Nome                |Descrição| 
|-------|-----------------------------------|---------|
|RF 01  |Iniciar                            |O programa deve possuir um botão com o valor “Iniciar”, que ao ser clicado, mostrará na tela a opção para informe dos nomes dos dois jogadores, assim como a escolha do iniciante.|
|RF 02  |Informe dos jogadores              |Após clicar em “Iniciar”, deve ser possível informar o nome dos dois jogadores da partida.|
|RF 03  |Escolha do iniciante               |Após o informe dos dois jogadores, deve ser possível escolher qual deles começará a partida.|
|RF 04  |Início da partida                  |Após a escolha do iniciante a partida começa. Após a primeira jogada, o cronômetro começa a marcar o tempo. Cada partida dura 30 minutos.|
|RF 05  |Jogada                             |Deve ser possível mover uma peça do tabuleiro, clicando em cima da mesma e arrastando-a para a posição escolhida, finalizando o movimento ao “soltar” o mouse sobre esta posição. As regras de uma jogada: - As peças se movem pulando as outras na horizontal e na vertical, nunca na diagonal. -Para mover-se, uma peça deve pular outra que lhe seja adjacente, caindo numa casa vazia imediatamente seguinte. A peça que foi pulada é retirada do jogo.|
|RF 05.1|Jogada – posição movimento inválido|Caso o jogador tente arrastar a peça para uma posição inválida  perante as regras do jogo, a peça deve ser “devolvida” à posição de origem. Não será necessário avisar o jogador sobre o procedimento, a movimentação involuntária deve ser um indício do erro.|
|RF 06  |Estatísticas                       |O programa deve exibir dados estatísticos sobre a partida, tais como: Quantidade de peças (total),Quantidades de peças restantes, Número de movimentos realizados|
|RF 07  |Manual                             |O programa deve possuir um link para um pequeno manual contendo um resumo do funcionamento do jogo, que deve estar acessível antes mesmo de iniciar a partida.|
|RF 08  |Finalização da partida             |A partida deve ser finalizada quando restar apenas uma peça no tabuleiro de um dos jogadores, neste caso este será o vencedor, ou quando o cronometro atinge 30 minutos. Para o segundo caso, se nenhum dos jogadores possuir somente uma peça nos seus tabuleiros, o jogador que possuir menos peças será considerado o vencedor da partida. Se os dois possuírem a mesma quantidade de peças no momento que o cronometro atinge o tempo limite, eles empatam. Seguindo as regras acima, assim que o jogo é finalizado, os jogadores devem ser notificados através de uma mensagem sobre o vencimento de um deles ou empate.|

**Requisitos Não Funcionais:**


|Cód.  |            Nome               | Descrição|
|------|-------------------------------|----------|
|RNF 01|Especificação de projeto       |Além do código Java, deve ser produzida especificação de projeto baseada em UML, segunda versão.|
|RNF 02|Interface gráfica              |A interface gráfica deve ser duplicada, seguindo o modelo proposto no protótipo apresentado posteriormente. No início do jogo, apenas a posição central do tabuleiro deve estar vazia.|
|RNF 03|Tecnologia da interface gráfica|A interface gráfica deve ser duplicada, seguindo o modelo proposto no protótipo apresentado posteriormente. No início do jogo, apenas a posição central do tabuleiro deve estar vazia.|

**Protótipos:**
