Erro 1: Contagem de 'loop for' errada.
Onde: Classe GerenciadorAutobots.java, método calcularEnergonTotal.
Boa prática violada: Ao invés de considerar que toda a contagem na programação 
inicia com 0, o código indicava um loop a mais, indo além dos valores da lista.
Isso ocorre por erro de condição na adição.
(ex: a lista tem 3 valores, mas o loop considera 4).
Correção: Na linha 19: (for (int i = 0; i < lista.size(); i++)), removi o sinal
de igualdade entre o < e a lista.size(), tornando a condição verdadeira para a 
adição correta.

Erro 2: nomes de difícil identificação - Nomes que não dizem nada
Onde: Autobot.java (mudanças posteriores em todas as classes, porém a designação
original está em Autobot.java) e GerenciadorAutobots.java.
Boa prática violada: O atributo 'n', 'e', e 'nivel' estavam muito abrangentes, 
sendo necessário a troca desses nomes por outros mais explícitos quanto à funcio-
nalidade de cada, ajudando o programador a não se perder quanto ao uso de cada
atributo. Além disso, o 'a' nos métodos criados é um nome que não indica nada,
sendo preciso modificá-lo.
Correção: em todas as linhas de código que os atributos descritos estavam, modifi-
quei seus nomes para palavras mais representativas: 'n' virou 'nome', 'e' virou 
'energon' e 'nivel' virou 'niveldeenergia'. O 'a' virou 'autobot', para indicar que
estamos falando deles.

Erro 3: atributos públicos - falta de encapsulamento
Onde: Autobot.java (mudanças posteriores em todas as classes).
Boa prática violada: Para evitar mal uso dos atributos (podendo gerar mudanças e 
comprometer o código e a integridade da empresa), eles devem ser privados ao invés
de públicos (encapsulamento). Depois, para usar os atributos, devemos fazer getters 
e setters.
Correção: Na classe de origem do problema, tornei os atributos privados e construí 
os getters e setters de cada atributo. Depois, modifiquei seus nomes em cada classe
onde estão presentes para usá-los (ex: getNome; setNome; etc).

Erro 4: Uso de número ao invés de variável - Números mágicos
Onde: Classe GerenciadorAutobots.java, método classificar e reparo.
Boa prática violada: Ao usarmos números soltos, é possível que o programador se con-
funda quanto à função/significado que esse número tem (o que ele representa) e, ao
modificarmos esse número, teremos muito trabalho mudando ele em todos os lugares que 
ele aparece. Portanto, criamos variáveis com nome para ele, sendo mais fácil de iden-
tificar seu uso e de modificar seu valor.
Correção: Declarei as variáveis:
private static final double EnergonElite = 500;
private static final double  EnergonPadrao = 200;
private static final double  EnergonPadrao = 100;
Depois, apliquei seu nome no código:
if (a.getEnergon() > EnergonElite) {
return "ELITE";
} else if (a.getEnergon() > EnergonPadrao) {
return "PADRAO";
if (autobot.getEnergon() < 0) {
throw new IllegalArgumentException("Energon negativo");
}
autobot.setEnergon(autobot.getEnergon() + EnergiaReparo);

Erro 5: Uso de == ao invés de equals
Onde: Classe GerenciadorAutobots.java - public autobot buscar
Boa prática violada: O == compara o local onde as infos estão, enquanto  o equals 
compara o texto em si.
Correção:
if (a.getNome() == nome) é corrigido para:
if (a.getNome().equals(nome))

Erro 6: O catch está vazio, então o erro de Energon negativo é lançado porém jogado fora 
sem deixar um alerta.
Onde: GerenciadorAutobots.java, método reparar.
Boa prática violada: tratamento de exceções (catch nunca vazio).
Correção: removi o try/catch vazio e lancei o  IllegalArgumentException quando o Energon
é negativo, documentando o @throws no Javadoc.

Erro 7: Documentação vaga e inútil.
Onde: Autobot.java e GerenciadorAutobots.java (métodos: (buscar, classificar, 
calcularEnergonTotal, reparar).
Boa prática violada: A documentação descreve pobremente o que está acontecendo no código,
sendo raza e apenas indicando o que o nome da classe ou do método automaticamente já indica.
Correção: Escrevi Javadocs nos métodos não óbvios (buscar, classificar, calcularEnergonTotal, 
reparar), explicando para o quê eles servem, seu objetivo no código.
