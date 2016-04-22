grammar Plant;

// Parser Rules

plantDeclaration : '@startuml' classDeclaration* '@enduml';

classDeclaration : 'class' TEXT classBody;

classBody : '{' classBodyDeclaration* '}';

classBodyDeclaration: fieldDeclaration | methodDeclaration ;

fieldDeclaration : modifierDeclaration? nameDeclaration ':' typeDeclaration;

methodDeclaration: modifierDeclaration? returnTypeMethodDeclaration? methodNameDeclaration paramDeclaration  ;

returnTypeMethodDeclaration: 'int' | 'String' | 'void'; 

paramDeclaration: '(' paramBodyDeclaration* ')';

firstParamBodyDeclaration: typeParamDeclaration TEXT;

paramBodyDeclaration: firstParamBodyDeclaration otherParamBodyDeclaration*;

otherParamBodyDeclaration: ',' typeParamDeclaration TEXT;

typeParamDeclaration: 'int' | 'String';  

typeDeclaration: 'int' | 'String'; 
 
modifierDeclaration :  MODIFIER;

nameDeclaration : TEXT;

methodNameDeclaration : TEXT;

// Lexer Rules

TEXT : ('a'..'z' | 'A'..'Z')+ ;

MODIFIER : '+' | '-' | '~' | '#';

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;