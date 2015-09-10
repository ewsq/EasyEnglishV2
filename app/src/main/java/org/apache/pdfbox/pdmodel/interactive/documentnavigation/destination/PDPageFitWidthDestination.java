package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;

/**
 * This represents a destination to a page at a y location and the width is magnified
 * to just fit on the screen.
 *
 * @author Ben Litchfield
 */
public class PDPageFitWidthDestination extends PDPageDestination
{

    /**
     * The type of this destination.
     */
    protected static final String TYPE = "FitH";
    /**
     * The type of this destination.
     */
    protected static final String TYPE_BOUNDED = "FitBH";

    /**
     * Default constructor.
     *
     */
    public PDPageFitWidthDestination()
    {
        super();
        array.growToSize(3);
        array.setName( 1, TYPE );

    }

    /**
     * Constructor from an existing destination array.
     *
     * @param arr The destination array.
     */
    public PDPageFitWidthDestination( COSArray arr )
    {
        super( arr );
    }


    /**
     * Get the top y coordinate.  A return value of -1 implies that the current y-coordinate
     * will be used.
     *
     * @return The top y coordinate.
     */
    public int getTop()
    {
        return array.getInt( 2 );
    }

    /**
     * Set the top y-coordinate, a value of -1 implies that the current y-coordinate
     * will be used.
     * @param y The top ycoordinate.
     */
    public void setTop( int y )
    {
        array.growToSize( 3 );
        if( y == -1 )
        {
            array.set( 2, (COSBase)null );
        }
        else
        {
            array.setInt( 2, y );
        }
    }

    /**
     * A flag indicating if this page destination should just fit bounding box of the PDF.
     *
     * @return true If the destination should fit just the bounding box.
     */
    public boolean fitBoundingBox()
    {
        return TYPE_BOUNDED.equals( array.getName( 1 ) );
    }

    /**
     * Set if this page destination should just fit the bounding box.  The default is false.
     *
     * @param fitBoundingBox A flag indicating if this should fit the bounding box.
     */
    public void setFitBoundingBox( boolean fitBoundingBox )
    {
        array.growToSize( 2 );
        if( fitBoundingBox )
        {
            array.setName( 1, TYPE_BOUNDED );
        }
        else
        {
            array.setName( 1, TYPE );
        }
    }
}