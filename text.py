def solution(letters):
	"""
	Return the number of different letters that appear in both lowercase and
	uppercase in the string `letters` such that all lowercase occurrences of
	that letter appear before any uppercase occurrence.

	Approach: single pass recording for each letter:
	  - last_lower[ch] = index of last lowercase occurrence (max index)
	  - first_upper[ch] = index of first uppercase occurrence (min index)
	After the pass, count letters where both exist and last_lower < first_upper.
	"""
	if not letters:
		return 0

	# Arrays for 26 english letters; use None to mean not seen
	last_lower = [None] * 26
	first_upper = [None] * 26

	for i, ch in enumerate(letters):
		if 'a' <= ch <= 'z':
			idx = ord(ch) - ord('a')
			last_lower[idx] = i  # keep updating to get last position
		elif 'A' <= ch <= 'Z':
			idx = ord(ch.lower()) - ord('a')
			if first_upper[idx] is None:
				first_upper[idx] = i  # keep earliest uppercase

	count = 0
	for idx in range(26):
		if last_lower[idx] is not None and first_upper[idx] is not None:
			if last_lower[idx] < first_upper[idx]:
				count += 1

	return count
