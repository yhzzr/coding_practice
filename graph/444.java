class Solution(object):
    def sequenceReconstruction(self, org, seqs):
        """
        :type org: List[int]
        :type seqs: List[List[int]]
        :rtype: bool
        """
        from collections import defaultdict, deque

        if not org or not any(seqs):
            return False
                
        nums = set()
        for seq in seqs:
            for num in seq:
                nums.add(num)
        
        if not all([num in nums for num in org]):
            return False
        
        G = { num: set() for num in set(nums)}
        for seq in seqs:
            for i in xrange(len(seq)-1):
                G[seq[i]].add(seq[i+1])
        
        in_edges = defaultdict(int)
        for num in G:
            for dep in G[num]:
                in_edges[dep] += 1
        
        L = []
        Q = deque([org[0]])
        while Q:
            num = Q.popleft()
            L.append(num)
            for dep in G[num]:
                in_edges[dep] -= 1
                if in_edges[dep] == 0:
                    Q.appendleft(dep)
        
        print L
        return L == org and len(L) == len(G)