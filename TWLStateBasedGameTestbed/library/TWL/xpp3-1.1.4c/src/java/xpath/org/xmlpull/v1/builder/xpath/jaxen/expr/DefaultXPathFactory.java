/*
 * $Header: /l/extreme/cvs/codes/XPP3/java/src/java/xpath/org/xmlpull/v1/builder/xpath/jaxen/expr/DefaultXPathFactory.java,v 1.1 2004/06/16 15:55:36 aslom Exp $
 * $Revision: 1.1 $
 * $Date: 2004/06/16 15:55:36 $
 *
 * ====================================================================
 *
 * Copyright (C) 2000-2002 bob mcwhirter & James Strachan.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions, and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions, and the disclaimer that follows 
 *    these conditions in the documentation and/or other materials 
 *    provided with the distribution.
 *
 * 3. The name "Jaxen" must not be used to endorse or promote products
 *    derived from this software without prior written permission.  For
 *    written permission, please contact license@jaxen.org.
 * 
 * 4. Products derived from this software may not be called "Jaxen", nor
 *    may "Jaxen" appear in their name, without prior written permission
 *    from the Jaxen Project Management (pm@jaxen.org).
 * 
 * In addition, we request (but do not require) that you include in the 
 * end-user documentation provided with the redistribution and/or in the 
 * software itself an acknowledgement equivalent to the following:
 *     "This product includes software developed by the
 *      Jaxen Project (http://www.jaxen.org/)."
 * Alternatively, the acknowledgment may be graphical using the logos 
 * available at http://www.jaxen.org/
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE Jaxen AUTHORS OR THE PROJECT
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * ====================================================================
 * This software consists of voluntary contributions made by many 
 * individuals on behalf of the Jaxen Project and was originally 
 * created by bob mcwhirter <bob@werken.com> and 
 * James Strachan <jstrachan@apache.org>.  For more information on the 
 * Jaxen Project, please see <http://www.jaxen.org/>.
 * 
 * $Id: DefaultXPathFactory.java,v 1.1 2004/06/16 15:55:36 aslom Exp $
 */



package org.xmlpull.v1.builder.xpath.jaxen.expr;

import org.xmlpull.v1.builder.xpath.jaxen.JaxenException;

import org.xmlpull.v1.builder.xpath.jaxen.expr.iter.*;

import org.xmlpull.v1.builder.xpath.saxpath.Axis;

public class DefaultXPathFactory implements XPathFactory
{
    public XPathExpr createXPath(Expr rootExpr) throws JaxenException
    {
        return new DefaultXPathExpr( rootExpr );
    }

    public PathExpr createPathExpr(FilterExpr filterExpr,
                                   LocationPath locationPath) throws JaxenException
    {
        return new DefaultPathExpr( filterExpr,
                                    locationPath );
    }

    public LocationPath createRelativeLocationPath() throws JaxenException
    {
        return new DefaultRelativeLocationPath();
    }

    public LocationPath createAbsoluteLocationPath() throws JaxenException
    {
        return new DefaultAbsoluteLocationPath();
    }

    public BinaryExpr createOrExpr(Expr lhs,
                                   Expr rhs) throws JaxenException
    {
        return new DefaultOrExpr( lhs,
                                  rhs );
    }

    public BinaryExpr createAndExpr(Expr lhs,
                                    Expr rhs) throws JaxenException
    {
        return new DefaultAndExpr( lhs,
                                   rhs );
    }

    public BinaryExpr createEqualityExpr(Expr lhs,
                                         Expr rhs,
                                         int equalityOperator) throws JaxenException
    {
        switch ( equalityOperator )
        {
            case EQUALS:
            {
                return new DefaultEqualsExpr( lhs,
                                              rhs );
            }
            case NOT_EQUALS:
            {
                return new DefaultNotEqualsExpr( lhs,
                                                 rhs );
            }
        }

        throw new JaxenException( "Unhandled operator in createEqualityExpr(): " + equalityOperator );
    }

    public BinaryExpr createRelationalExpr(Expr lhs,
                                           Expr rhs,
                                           int relationalOperator) throws JaxenException
    {
        switch ( relationalOperator )
        {
            case LESS_THAN:
            {
                return new DefaultLessThanExpr( lhs,
                                                rhs );
            }
            case GREATER_THAN:
            {
                return new DefaultGreaterThanExpr( lhs,
                                                   rhs );
            }
            case LESS_THAN_EQUALS:
            {
                return new DefaultLessThanEqualExpr( lhs,
                                                     rhs );
            }
            case GREATER_THAN_EQUALS:
            {
                return new DefaultGreaterThanEqualExpr( lhs,
                                                        rhs );
            }
        }

        throw new JaxenException( "Unhandled operator in createRelationalExpr(): " + relationalOperator );
    }

    public BinaryExpr createAdditiveExpr(Expr lhs,
                                         Expr rhs,
                                         int additiveOperator) throws JaxenException
    {
        switch ( additiveOperator )
        {
            case ADD:
            {
                return new DefaultPlusExpr( lhs,
                                            rhs );
            }
            case SUBTRACT:
            {
                return new DefaultMinusExpr( lhs,
                                             rhs );
            }
        }

        throw new JaxenException( "Unhandled operator in createAdditiveExpr(): " + additiveOperator );
    }

    public BinaryExpr createMultiplicativeExpr(Expr lhs,
                                               Expr rhs,
                                               int multiplicativeOperator) throws JaxenException
    {
        switch ( multiplicativeOperator )
        {
            case MULTIPLY:
            {
                return new DefaultMultiplyExpr( lhs,
                                                rhs );
            }
            case DIV:
            {
                return new DefaultDivExpr( lhs,
                                           rhs );
            }
            case MOD:
            {
                return new DefaultModExpr( lhs,
                                           rhs );
            }
        }

        throw new JaxenException( "Unhandled operator in createMultiplicativeExpr(): " + multiplicativeOperator );
    }

    public Expr createUnaryExpr(Expr expr,
                                int unaryOperator) throws JaxenException
    {
        switch ( unaryOperator )
        {
            case NEGATIVE:
            {
                return new DefaultUnaryExpr( expr );
            }
        }

        return expr;
    }

    public UnionExpr createUnionExpr(Expr lhs,
                                     Expr rhs) throws JaxenException
    {
        return new DefaultUnionExpr( lhs,
                                     rhs );
    }

    public FilterExpr createFilterExpr(Expr expr) throws JaxenException
    {
        return new DefaultFilterExpr( expr );
    }

    public FunctionCallExpr createFunctionCallExpr(String prefix,
                                                   String functionName) throws JaxenException
    {
        return new DefaultFunctionCallExpr( prefix,
                                            functionName );
    }

    public NumberExpr createNumberExpr(int number) throws JaxenException
    {
        // return new DefaultNumberExpr( new Integer(number) );
      return new DefaultNumberExpr( new Double(number) );
    }

    public NumberExpr createNumberExpr(double number) throws JaxenException
    {
        return new DefaultNumberExpr( new Double(number) );
    }

    public LiteralExpr createLiteralExpr(String literal) throws JaxenException
    {
        return new DefaultLiteralExpr( literal );
    }

    public VariableReferenceExpr createVariableReferenceExpr(String prefix,
                                                             String variable) throws JaxenException
    {
        return new DefaultVariableReferenceExpr( prefix,
                                                 variable );
    }

    public Step createNameStep(int axis,
                               String prefix,
                               String localName) throws JaxenException
    {
        IterableAxis iter = getIterableAxis( axis );

        return new DefaultNameStep( iter,
                                    prefix,
                                    localName );
    }

    public Step createTextNodeStep(int axis) throws JaxenException
    {
        IterableAxis iter = getIterableAxis( axis );

        return new DefaultTextNodeStep( iter );
    }

    public Step createCommentNodeStep(int axis) throws JaxenException
    {
        IterableAxis iter = getIterableAxis( axis );

        return new DefaultCommentNodeStep( iter );
    }

    public Step createAllNodeStep(int axis) throws JaxenException
    {
        IterableAxis iter = getIterableAxis( axis );

        return new DefaultAllNodeStep( iter );
    }

    public Step createProcessingInstructionNodeStep(int axis,
                                                    String piName) throws JaxenException
    {
        IterableAxis iter = getIterableAxis( axis );

        return new DefaultProcessingInstructionNodeStep( iter,
                                                         piName );
    }

    public Predicate createPredicate(Expr predicateExpr) throws JaxenException
    {
        return new DefaultPredicate( predicateExpr );
    }

    protected IterableAxis getIterableAxis(int axis)
    {
        IterableAxis iter = null;

        switch ( axis )
        {
            case Axis.CHILD:
            {
                iter = new IterableChildAxis( axis );
                break;
            }
            case Axis.DESCENDANT:
            {
                iter = new IterableDescendantAxis( axis );
                break;
            }
            case Axis.PARENT:
            {
                iter = new IterableParentAxis( axis );
                break;
            }
            case Axis.FOLLOWING_SIBLING:
            {
                iter = new IterableFollowingSiblingAxis( axis );
                break;
            }
            case Axis.PRECEDING_SIBLING:
            {
                iter = new IterablePrecedingSiblingAxis( axis );
                break;
            }
            case Axis.FOLLOWING:
            {
                iter = new IterableFollowingAxis( axis );
                break;
            }
            case Axis.PRECEDING:
            {
                iter = new IterablePrecedingAxis( axis );
                break;
            }
            case Axis.ATTRIBUTE:
            {
                iter = new IterableAttributeAxis( axis );
                break;
            }
            case Axis.NAMESPACE:
            {
                iter = new IterableNamespaceAxis( axis );
                break;
            }
            case Axis.SELF:
            {
                iter = new IterableSelfAxis( axis );
                break;
            }
            case Axis.DESCENDANT_OR_SELF:
            {
                iter = new IterableDescendantOrSelfAxis( axis );
                break;
            }
            case Axis.ANCESTOR_OR_SELF:
            {
                iter = new IterableAncestorOrSelfAxis( axis );
                break;
            }
            case Axis.ANCESTOR:
            {
                iter = new IterableAncestorAxis( axis );
                break;
            }
        }

        return iter;
    }
                                               
}
