# Folha de Pagamentos

Projeto compilado com openjdk 11.0.3 e IDE utilizada Eclipse.

## Instruções de execução:

Fornecer as informações sempre sem acentos ou caracteres especiais. Valores monetários devem ser fornecidos com um ponto para representar casas decimais (200.30).<br>

### Como funciona:
#### Funcionalidade 1

Os três métodos de pagamento são: cheque correios; cheque maos; deposito conta.<br>
As informações sindicais devem ser da forma 
Sim ou Nao - se participa do sindicato ou não; taxa mensal em porcentagem.<br>

Exemplo de uso da funcionalidade 1:<br>
Jeremias<br>
Ufal Brasil<br>
Horista<br>
1500.00<br>
cheque pelos correios<br>
Sim<br>
200.00

#### Funcionalidade 2

Só digitar o ID do funcionario, que o mesmo sera removido do sistema.<br>
Exemplo:<br>
49

#### Funcionalidade 3

Exemplo dos horários de entrada e saída:<br>
8 <br>
30<br>
16<br>
30

#### Funcionalidade 4

Exemplo:<br>
49<br>
200.00

#### Funcionalidade 5

Digitar o ID normal, não o do sindicato, já que é verificado se o mesmo pertence ao sindicato ou não.<br>
Exemplo:<br>
49<br>
200.00

#### Funcionalidade 6

Deve-se responder com "Sim" aqueles detalhes que deseja-se mudar, e "Nao" aqueles que não.<br>
Ao alterar o contrato de um funcionário, deve-se necessariamente fornecer o novo atributo associado (salário, salário e % de comissão, salário/hora).<br>
Ao mudar o contrato de um funcionário, o sistema associará a agenda de pagamento default daquele contrato.

#### Funcionalidade 7

Essa deve ser a última funcionalidade realizada em cada dia, pois irá incrementar a data do sistema, e pagar os funcionários de acordo com o dia.

#### Funcionalidade 8

Undo/redo podem ser realizados sobre todas as funcionalidades, com exceção da 8 (ela mesma) e a 9,10.<br>
Redo só poderá ser utilizado se a funcionalidade utilizada anteriormente foi a 8.

### Funcionalidade 9

Modificar a agenda do pagamento do empregado para uma nova, basta digitar o Id e escolher para qual tipo queira muda [1] Semanal [2] Bissemanal [3] Mensal, de acordo com o default.<br>
Obs: Considerei que ele não ira mudar para o tipo que ele ja está.<br>
Exemplo:<br>
49<br>
1

#### Funcionalidade 10
Modificar a agenda do pagamento do empregado para uma nova, basta digitar o Id e escolher para qual tipo queira muda [1] Semanal [2] Bissemanal [3] Mensal, e escolher o dia da semana ou o dia do mês.<br>
Obs1: Considerei que ele não ira mudar para o tipo que ele ja está.<br>
obs2:Caso for Mensal tem que digitar o dia do mês, Ex: 7;<br>
obs3: Caso for Bissemanal ou Semanal, tera que digitar o dia da semana com a primeira letra Maiúscula, Ex: Segunda<br>
Exemplo:<br>
<li>49<br>
<li>1<br>
<li>Segunda<br>
 
 #### Obs: Considerei que o usuário é inteligente, ou seja, não irá errar os comandos
