
var secret = 42;

var node = function( value ) {
    var result = {};

    var value = value;
    var leftChild = null;
    var rightChild = null;

    result.getValue = function() { return value; };
    result.getLeftChild = function() { return leftChild; };
    result.getRightChild = function() { return rightChild; };

    result.setLeftChild = function( child ) { leftChild = child; };
    result.setRightChild = function( child ) { rightChild = child; };

    return result;
}; // node( value )

var bst = function() {
    var result = {};
    
    var root = null;

    result.add = function( n ) {
	if( root === null ) {
	    root = node( n );
	} // if
	else if( n === root.getValue() ) {
	    // do nothing (do not add duplicate values)
	} // else if
	else {
	    addHelper( n, root );
        } // else

    }; // add( n )

    var addHelper = function( n, currentNode ) {
        if( n === currentNode.getValue() ) {
	    // do nothing (do not add duplicate values)
	} // if
	else if( n < currentNode.getValue() ) {
	    if( currentNode.getLeftChild() === null ) {
		currentNode.setLeftChild( node(n) );
	    } // if
	    else {
		addHelper( n, currentNode.getLeftChild() );
	    } // else
	} // else if
	else {
	    if( currentNode.getRightChild() === null ) {
		currentNode.setRightChild( node(n) );
	    } // if
	    else {
		addHelper( n, currentNode.getRightChild() );
	    } // else
	} // else
    } // addHelper( n, currentNode )

    result.inOrder = function() {
	if( root === null ) {
	    // do nothing if tree is empty---there's nothing to print!
	} // if
	else {
	    inOrderHelper( root );
	} // else
    }; // inOrder()

    var inOrderHelper = function( currentNode ) {
        if( currentNode === null ) {
	    // stop recursion when we reach a leaf
	} // if
	else {
	    inOrderHelper( currentNode.getLeftChild() );
	    console.log( currentNode.getValue() );
	    inOrderHelper( currentNode.getRightChild() );
	} // else
    }; // inOrderHelper()
    
    return result;
}; // bst()
