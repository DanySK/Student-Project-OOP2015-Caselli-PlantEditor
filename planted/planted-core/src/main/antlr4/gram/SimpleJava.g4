grammar SimpleJava;

// Parser Rules

classDeclaration : modifier 'class' TEXT classBody;
classBody: '{' classBodyDeclaration* '}';
classBodyDeclaration: fieldDeclaration | methodDeclaration;
methodDeclaration: modifier? methodReturnType methodName paramDeclaration methodBodyDeclaration;
methodName: TEXT;

methodBodyDeclaration: '{' methodBody '}';
methodBody: ((TEXT | '.' | '=')* ';')*;


paramDeclaration:'(' paramBodyDeclaration* ')';
paramBodyDeclaration: firstParamBodyDeclaration otherParamBodyDeclaration*;

firstParamBodyDeclaration: paramType paramName;
otherParamBodyDeclaration: ',' paramType paramName;
paramName : TEXT;
fieldDeclaration: modifier? fieldType fieldName fieldInitializion? ';';
fieldInitializion: '=' TEXT;
fieldName: TEXT;
modifier
	:	'public'
	|	'protected'
	|	'private'
//	|	'abstract'
//	|	'static'
//	|	'final'
	;

methodReturnType: 'void' | type;
type: 'int' | 'String' | 'boolean';	
fieldType: type;	
paramType: type;

// Lexer Rules

TEXT : ('a'..'z' | 'A'..'Z')+ ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ -> skip ;