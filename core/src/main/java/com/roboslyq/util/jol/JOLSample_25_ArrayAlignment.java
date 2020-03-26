package com.roboslyq.util.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;

/**
 * @author Aleksey Shipilev
 */
public class JOLSample_25_ArrayAlignment {

    /*
     * This sample showcases that the alignment requirements are also
     * affecting arrays. This test introspects the byte[] arrays of different
     * small sizes. It may be seen that many arrays are actually consuming the
     * same space, since they are also required to be externally aligned.
     *
     * The internal alignment can be demonstrated in some specific VM modes, e.g.
     * on long[] arrays with 32-bit modes. There, the zero-th element of long[]
     * array should be aligned by 8.
     *
     * Or, even on byte[] arrays in 64-bit mode with compressed references disabled,
     * on some VMs:
     *   https://bugs.openjdk.java.net/browse/JDK-8139457
     */

    public static void main(String[] args) throws Exception {
        out.println(VM.current().details());
        out.println(ClassLayout.parseInstance(new long[0]).toPrintable());
        for (int size = 0; size <= 8; size++) {
            out.println(ClassLayout.parseInstance(new byte[size]).toPrintable());
        }
    }

}