# RESTA-UM-INE5608
projeto implementado para a disciplina INE5608

## Especificação de requisitos
**Projeto:** Resta Um
####Especificação de Requisitos de Software:
  - Versão 2.0
  - 05/07/2015

|Versão|     Autor(es)     |   Data   |                   Ação                 |
|------|-------------------|----------|----------------------------------------|
| 1.0  |Thaise Santos Souza|03/04/2015|Início do desenvolvimento dos requisitos|
| 1.1  |Luiz Ricardo F. M. |05/06/2015|Alteração dos RF 01, 02, 04, 05, 06, 08 |
| 1.2  |Luiz Ricardo F. M. |13/06/2015|Adição do requisito Conectar ao servidor|
| 1.3  |Luiz Ricardo F. M. |01/07/2015|Remoção do RF Manual e alteração NRF 03 |
| 2.0  |Luiz Ricardo F. M. |05/07/2015|Revisão final de requisítos e protótipos|

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
|RF 01  |Conectar ao Servidor               |O jogador deve ser capaz de se conectar ao servidor por meio de ip ou dns em posse do mesmo|
|RF 02  |Iniciar                            |Ao Iniciar mostrará tela a opção para informe o nome do jogador, assim como a escolha do iniciante.|
|RF 03  |Informe dos jogadores              |Deve ser possível informar o nome dos dois jogadores da partida.|
|RF 04  |Escolha do iniciante               |Após o informe dos dois jogadores, o programa escolherá qual deles começará a partida.|
|RF 05  |Início da partida                  |Após a escolha do iniciante a partida começa. Após a primeira jogada, o cronômetro começa a marcar o tempo.|
|RF 06  |Jogada                             |Deve ser possível mover uma peça do tabuleiro, clicando em cima da mesma e após isso clicar na posição escolhida. As regras de uma jogada: - As peças se movem pulando as outras na horizontal e na vertical, nunca na diagonal. -Para mover-se, uma peça deve pular outra que lhe seja adjacente, caindo numa casa vazia imediatamente seguinte. A peça que foi pulada é retirada do jogo.|
|RF 06.1|Jogada – posição movimento inválido|Caso o jogador tente mover a peça para uma posição inválida  perante as regras do jogo, a peça não se ficará em sua posição de origem. Não será necessário avisar o jogador sobre o procedimento, a não movimentação  deve ser um indício do erro.|
|RF 07  |Estatísticas                       |O programa deve exibir dados estatísticos sobre a partida, tais como: Tempo total de jogo e número de movimentos realizados|
|RF 08  |Finalização da partida             |A partida deve ser finalizada quando restar apenas uma peça no tabuleiro de um dos jogadores, neste caso este será o vencedor, ou quando o tabuleiro dos adversario ficar bloqueado. Seguindo as regras acima, assim que o jogo é finalizado, os jogadores devem ser notificados através de uma mensagem sobre o vencimento de um deles|


**Requisitos Não Funcionais:**


|Cód.  |            Nome               | Descrição|
|------|-------------------------------|----------|
|RNF 01|Especificação de projeto       |Além do código Java, deve ser produzida especificação de projeto baseada em UML, segunda versão.|
|RNF 02|Interface gráfica              |Deve dispor do tabuleiro do jogador e de seu adversário além do tempo de jogo e número de peças comidas de ambos.No início do jogo, apenas a posição central do tabuleiro deve estar vazia.|
|RNF 03|Tecnologia da interface gráfica|Será desenvolvida em javax Swing|

**Protótipos:**
