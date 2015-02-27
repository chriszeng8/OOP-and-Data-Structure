Casting ```int``` to ```byte```


```
int i =132;
byte b =(byte)i;
System.out.println(b);
```

To understand how it works, we need to know that computers work in bits.

132 in base 10 (decimal) is 10000100 in base 2 (binary). Since Java stores int in 32 bits, what we have is

00000000_00000000_00000000_10000100
When an int is converted into a byte, Java chops-off the left-most 24 bits. What is left is 10000100.

In two's complement, the left-most bit is used as the sign. If the left-most bit is 0, nothing furthur will be done.

If the left-most bit is 1 (as we have here), it means that the number is negative and more work needs to be done. To get the magnitude, we minus one then apply one's complement (apply one's complement means we invert the bits):

10000100 - 1 = 10000011

10000011 inverted = 01111100

01111100 when interpreted as a decimal number, is 124.

So we have a negative number with a magnitude of 124, giving us -124.