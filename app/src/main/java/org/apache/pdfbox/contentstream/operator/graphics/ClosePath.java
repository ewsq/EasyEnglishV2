package org.apache.pdfbox.contentstream.operator.graphics;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;

/**
 * h Close the path.
 *
 * @author Ben Litchfield
 */
public final class ClosePath extends GraphicsOperatorProcessor
{
    @Override
    public void process(Operator operator, List<COSBase> operands) throws IOException
    {
        context.closePath();
    }

    @Override
    public String getName()
    {
        return "h";
    }
}
