//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.easy.spring.params;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class StringUtils {
    private static final String PREFIX = "\\u";

    private StringUtils() {
    }

    public static boolean equals(String s1, String s2) {
        return null == s1 ? null == s2 : s1.equals(s2);
    }

    public static boolean equalsAfterTrim(String s1, String s2) {
        return null == s1 ? null == s2 : s1.trim().equals(s2.trim());
    }

    public static boolean isEmpty(String s) {
        return null == s || s.trim().length() < 1;
    }

    public static boolean isNotEmpty(String s) {
        return null != s && s.trim().length() > 0;
    }



    public static String cutString(String s, int maxLen, String charset) {
        StringBuilder sb = new StringBuilder();
        if (s != null) {
            int len = length(s, charset);
            if (maxLen < 5) {
                maxLen = 5;
            }

            if (len <= maxLen) {
                sb.append(s);
            } else {
                int fetchLen = 0;
                int needLen = maxLen - 3;

                for(int i = 0; i < needLen; ++i) {
                    char c = s.charAt(i);
                    fetchLen += length(String.valueOf(c), charset);
                    if (fetchLen > needLen) {
                        break;
                    }

                    sb.append(c);
                }

                len = sb.toString().getBytes().length;
                if (len + 3 > maxLen) {
                    sb.append("..");
                } else if (len + 3 < maxLen) {
                    sb.append("...");
                    sb.append(" ");
                } else {
                    sb.append("...");
                }
            }
        }

        return sb.toString();
    }

    public static int length(String s) {
        return null == s ? 0 : s.getBytes().length;
    }

    public static int length(String s, String charset) {
        if (null == s) {
            return 0;
        } else {
            try {
                return s.getBytes(charset).length;
            } catch (Exception var3) {
                return s.getBytes().length;
            }
        }
    }


    public static String[] chunkString(String s, int blockLength, int blockNum) throws Exception {
        return chunkString(s, blockLength, Charset.defaultCharset().name(), blockNum);
    }

    public static String[] chunkString(String s, int blockLength) throws Exception {
        return chunkString(s, blockLength, Charset.defaultCharset().name(), 0);
    }

    public static String[] chunkString(String s, int blockLength, String charset) throws Exception {
        return chunkString(s, blockLength, charset, 0);
    }

    public static String[] chunkString(String s, int blockLength, String charset, int blockNum) throws Exception {
        int len = 0;
        List list = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int j = 0;

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            len += length(String.valueOf(c), charset);
            if (len > blockLength) {
                --i;
                ++j;
                if (j > s.length()) {
                    throw new Exception("For charset " + charset + " length of block (" + blockLength + ") is to small");
                }

                list.add(sb.toString());
                len = 0;
                sb.setLength(0);
                if (blockNum > 0 && j >= blockNum) {
                    break;
                }
            } else {
                sb.append(c);
            }
        }

        if (sb.length() > 0) {
            list.add(sb.toString());
        }

        return (String[])((String[])list.toArray(new String[list.size()]));
    }

    public static String[] split(String s, char sc) {
        return split(s, sc, true);
    }

    public static String[] split(String s, char sc, boolean skipNull) {
        if (null == s) {
            return new String[0];
        } else {
            List list = new ArrayList();
            StringBuilder sb = new StringBuilder();
            StringBuilder sbs = new StringBuilder();

            for(int i = 0; i <= s.length(); ++i) {
                char c;
                if (i < s.length()) {
                    c = s.charAt(i);
                } else {
                    c = sc;
                }

                if ((' ' == c || c == '\r' || c == '\n' || c == '\t') && c != sc) {
                    if (sb.length() >= 1) {
                        sbs.append(c);
                    }
                } else if (sc == c) {
                    if (!skipNull || sb.length() >= 1) {
                        list.add(sb.toString());
                        sb.setLength(0);
                        sbs.setLength(0);
                    }
                } else {
                    if (sbs.length() > 0) {
                        sb.append(sbs);
                        sbs.setLength(0);
                    }

                    sb.append(c);
                }
            }

            return (String[])((String[])list.toArray(new String[list.size()]));
        }
    }




    public static String join(Object[] array) {
        return join((Object[])array, (String)null);
    }

    public static String join(Object[] array, char separator) {
        return array == null ? null : join(array, separator, 0, array.length);
    }

    public static String join(Object[] array, char separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        } else {
            int bufSize = endIndex - startIndex;
            if (bufSize <= 0) {
                return "";
            } else {
                bufSize *= (array[startIndex] == null ? 16 : array[startIndex].toString().length()) + 1;
                StringBuffer buf = new StringBuffer(bufSize);

                for(int i = startIndex; i < endIndex; ++i) {
                    if (i > startIndex) {
                        buf.append(separator);
                    }

                    if (array[i] != null) {
                        buf.append(array[i]);
                    }
                }

                return buf.toString();
            }
        }
    }

    public static String join(Object[] array, String separator) {
        return array == null ? null : join(array, separator, 0, array.length);
    }

    public static String join(Object[] array, String separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        } else {
            if (separator == null) {
                separator = "";
            }

            int bufSize = endIndex - startIndex;
            if (bufSize <= 0) {
                return "";
            } else {
                bufSize *= (array[startIndex] == null ? 16 : array[startIndex].toString().length()) + separator.length();
                StringBuffer buf = new StringBuffer(bufSize);

                for(int i = startIndex; i < endIndex; ++i) {
                    if (i > startIndex) {
                        buf.append(separator);
                    }

                    if (array[i] != null) {
                        buf.append(array[i]);
                    }
                }

                return buf.toString();
            }
        }
    }

    public static String join(Iterator iterator, char separator) {
        if (iterator == null) {
            return null;
        } else if (!iterator.hasNext()) {
            return "";
        } else {
            Object first = iterator.next();
            if (!iterator.hasNext()) {
                return toString(first);
            } else {
                StringBuffer buf = new StringBuffer(256);
                if (first != null) {
                    buf.append(first);
                }

                while(iterator.hasNext()) {
                    buf.append(separator);
                    Object obj = iterator.next();
                    if (obj != null) {
                        buf.append(obj);
                    }
                }

                return buf.toString();
            }
        }
    }

    public static String join(Iterator iterator, String separator) {
        if (iterator == null) {
            return null;
        } else if (!iterator.hasNext()) {
            return "";
        } else {
            Object first = iterator.next();
            if (!iterator.hasNext()) {
                return toString(first);
            } else {
                StringBuilder buf = new StringBuilder(256);
                if (first != null) {
                    buf.append(first);
                }

                while(iterator.hasNext()) {
                    if (separator != null) {
                        buf.append(separator);
                    }

                    Object obj = iterator.next();
                    if (obj != null) {
                        buf.append(obj);
                    }
                }

                return buf.toString();
            }
        }
    }

    public static String join(Collection collection, char separator) {
        return collection == null ? null : join(collection.iterator(), separator);
    }

    public static String join(Collection collection, String separator) {
        return collection == null ? null : join(collection.iterator(), separator);
    }

    public static String toString(Object obj) {
        return null == obj ? "" : obj.toString();
    }

    public static String substr(String s, int len, String charset) {
        if (strLen(s, charset) <= len) {
            return s;
        } else {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                int nl = strLen((new StringBuilder(sb)).append(c).toString(), charset);
                if (nl > len) {
                    break;
                }

                if (nl == len) {
                    sb.append(c);
                    break;
                }

                sb.append(c);
            }

            return sb.toString();
        }
    }

    public static String substringAfter(String str, String separator) {
        if (isEmpty(str)) {
            return str;
        } else if (null == separator) {
            return "";
        } else {
            int pos = str.indexOf(separator);
            return pos == -1 ? "" : str.substring(pos + separator.length());
        }
    }

    public static int strLen(String s, String encoding) {
        if (null == s) {
            return 0;
        } else {
            try {
                return s.getBytes(encoding).length;
            } catch (Exception var3) {
                return s.length();
            }
        }
    }

    public static String native2ascii(String text) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            String ascii = char2ascii(ch);
            sb.append(ascii);
        }

        return sb.toString();
    }

    private static String char2ascii(char ch) {
        if (ch < 256) {
            return Character.toString(ch);
        } else {
            String hex = Integer.toHexString(ch);
            if (hex.length() < 4) {
                hex = "0" + hex;
            }

            return "\\u" + hex;
        }
    }

    public static String ascii2native(String text) {
        StringBuilder sb = new StringBuilder();
        int start = 0;

        for(int idx = text.indexOf("\\u"); idx != -1; idx = text.indexOf("\\u", start)) {
            sb.append(text.substring(start, idx));
            String ascii = text.substring(idx + 2, idx + 6);
            char ch = (char)Integer.parseInt(ascii, 16);
            sb.append(ch);
            start = idx + 6;
        }

        sb.append(text.substring(start));
        return sb.toString();
    }

    public static String escapeRegexp(String regexp, boolean escapeSlash) {
        if (null == regexp) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < regexp.length(); ++i) {
                char c = regexp.charAt(i);
                if (c == '$' || c == '(' || c == ')' || c == '+' || c == '^' || c == '[' || c == ']' || c == '.' || c == '|' || c == '\\' || escapeSlash && c == '/' || c == '*' || c == '{' || c == '}' || c == '?') {
                    sb.append('\\');
                    sb.append('\\');
                }

                sb.append(c);
            }

            return sb.toString();
        }
    }

}
